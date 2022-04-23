package com.neu.movie_recommend.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.neu.movie_recommend.domain.Commodity;
import com.neu.movie_recommend.domain.UserPreference;
import com.neu.movie_recommend.service.ICommodityService;
import com.neu.movie_recommend.service.IRecommendService;
import com.neu.movie_recommend.service.IUserPreferenceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author rzh
 * @date 2022/3/18 - 23:30
 */
@Service
@Slf4j
@AllArgsConstructor
public class RecommendServiceImpl implements IRecommendService {
    private final ICommodityService iCommodityService;
    private final IUserPreferenceService iUserPreferenceService;

    @Override
    public Page<Commodity> getRecommendCommodityByUser(Page<Commodity> page, Long userId, int count) throws TasteException {
        DataModel dataModel = this.createDataModel();

        // 计算相拟度，相拟度算法很多种，采用基于皮尔逊相关性的相拟度
        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);

        // 计算最近邻域，邻居有两种算法，基于固定数量的邻居和基于相拟度的邻居，这里使用基于固定数量的邻居
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(100, similarity, dataModel);
        // 构建推荐器，基于用户的协同过滤推荐
        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);

        // 根据用户 推荐商品
        List<Long> commodityIds = recommender.recommend(userId, count).stream()
                .map(RecommendedItem::getItemID)
                .collect(Collectors.toList());

        return iCommodityService.findCommodityByIds(page,commodityIds);
    }

    @Override
    public Page<Commodity> getRecommendCommodityByCommodity(int pageNum,int pageSize,Long userId, Long commodityId, int count) throws TasteException {
        DataModel dataModel = this.createDataModel();

        // 采用基于皮尔逊相关性的相拟度
        ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        // 基于物品的协同过滤推荐
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);
        // 根据电影 推荐电影
        List<RecommendedItem> recommendedItemList = recommender.recommendedBecause(userId, commodityId, 10);
        List<Long> itemIds = new ArrayList<>();
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(recommendedItem);
            itemIds.add(recommendedItem.getItemID());
        }
        System.out.println("推荐出来商品的id集合" + itemIds);


        Page<Commodity> page = new Page();
        if(itemIds.size()!=0)
            page = iCommodityService.findCommodityByIds(new Page<>(pageNum,pageSize),itemIds);
        return page;
    }

    private DataModel createDataModel() {
        FastByIDMap<PreferenceArray> fastByIdMap = new FastByIDMap<>();

        iUserPreferenceService.getAllUserPreference().stream()
                .collect(Collectors.groupingBy(UserPreference::getUid))
                .values()
                .stream()
                .map(userPreferences -> userPreferences.stream()
                        .map(item -> new GenericPreference(item.getUid(), item.getPid(), item.getVal()))
                        .toArray(GenericPreference[]::new)
                )
                .forEach(genericArrayPreference -> fastByIdMap.put(genericArrayPreference[0].getUserID(),
                                    new GenericUserPreferenceArray(Arrays.asList(genericArrayPreference))));

        return new GenericDataModel(fastByIdMap);
    }
}
