package com.neu.shopping_recommend.service;

import com.neu.shopping_recommend.domain.Commodity;
import org.apache.mahout.cf.taste.common.TasteException;

import java.util.List;

/**
 * @author rzh
 * @date 2021/10/12 - 23:15
 */
public interface IRecommendService {
    /**
     * 基于用户的商品推荐
     * @param userId 用户id
     * @param count 推荐数量
     * @return 推荐的商品
     * @throws TasteException Taste引擎内部发生错误时引发的异常
     */
    List<Commodity> getRecommendCommodityByUser(Long userId, int count) throws TasteException;

    /**
     * 基于内容的商品推荐
     * @param userId 用户id
     * @param commodityId 商品id
     * @param count 推荐数量
     * @return 推荐的商品
     * @throws TasteException Taste引擎内部发生错误时引发的异常
     */
    List<Commodity> getRecommendCommodityByCommodity(Long userId, Long commodityId, int count) throws TasteException;
}
