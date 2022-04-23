package com.neu.movie_recommend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neu.movie_recommend.domain.Commodity;
import com.neu.movie_recommend.dao.ICommodityMapper;
import com.neu.movie_recommend.service.ICommodityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rzh
 * @date 2022/3/18 - 23:17
 */
@Service
@AllArgsConstructor
public class CommodityServiceImpl implements ICommodityService {
    private final ICommodityMapper ICommodityMapper;

    @Override
    public Page<Commodity> findCommodityByIds(Page<Commodity> page, List<Long> ids) {
        LambdaQueryWrapper<Commodity> commodityWrapper = Wrappers.lambdaQuery();
        commodityWrapper.in(Commodity::getPid, ids);
        System.out.println(ids);

        return ids.size()!=0 ? page.setRecords(ICommodityMapper.selectList(commodityWrapper)) : page;
    }
}
