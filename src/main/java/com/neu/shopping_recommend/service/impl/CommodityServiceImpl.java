package com.neu.shopping_recommend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.shopping_recommend.dao.ICommodityMapper;
import com.neu.shopping_recommend.domain.Commodity;
import com.neu.shopping_recommend.service.ICommodityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rzh
 * @date 2021/10/12 - 23:17
 */
@Service
@AllArgsConstructor
public class CommodityServiceImpl implements ICommodityService {
    private final ICommodityMapper ICommodityMapper;

    @Override
    public List<Commodity> findCommodityByIds(List<Long> ids) {
        LambdaQueryWrapper<Commodity> commodityWrapper = Wrappers.lambdaQuery();
        commodityWrapper.in(Commodity::getPid, ids);

        return ICommodityMapper.selectList(commodityWrapper);
    }
}
