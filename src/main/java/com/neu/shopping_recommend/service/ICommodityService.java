package com.neu.shopping_recommend.service;

import com.neu.shopping_recommend.domain.Commodity;

import java.util.List;

/**
 * @author rzh
 * @date 2021/10/12 - 23:14
 */
public interface ICommodityService {
    /**
     * 获取商品数据通过商品ids
     * @param ids 商品id集合
     * @return 商品数据
     */
    List<Commodity> findCommodityByIds(List<Long> ids);
}
