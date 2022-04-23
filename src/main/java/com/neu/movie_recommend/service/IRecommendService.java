package com.neu.movie_recommend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neu.movie_recommend.domain.Commodity;
import org.apache.mahout.cf.taste.common.TasteException;

/**
 * @author rzh
 * @date 2022/3/18 - 23:15
 */
public interface IRecommendService {
    /**
     * 基于用户的商品推荐
     * @param userId 用户id
     * @param count 推荐数量
     * @return 推荐的商品
     * @throws TasteException Taste引擎内部发生错误时引发的异常
     */
    Page<Commodity> getRecommendCommodityByUser(Page<Commodity> page, Long userId, int count) throws TasteException;

    /**
     * 基于内容的商品推荐
     * @param userId 用户id
     * @param commodityId 商品id
     * @param count 推荐数量
     * @return 推荐的商品
     * @throws TasteException Taste引擎内部发生错误时引发的异常
     */
    Page<Commodity> getRecommendCommodityByCommodity(int pageNum,int pageSize,Long userId, Long commodityId, int count) throws TasteException;
}
