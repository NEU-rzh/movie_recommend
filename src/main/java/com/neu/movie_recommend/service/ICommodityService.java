package com.neu.movie_recommend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neu.movie_recommend.domain.Commodity;

import java.util.List;

/**
 * @author rzh
 * @date 2022/3/18 - 23:14
 */
public interface ICommodityService {
    /**
     * 获取商品数据通过商品ids
     * @param ids 商品id集合
     * @return 商品数据Page类型返回
     */
    Page<Commodity> findCommodityByIds(Page<Commodity> page, List<Long> ids);
}
