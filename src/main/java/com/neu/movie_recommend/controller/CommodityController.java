package com.neu.movie_recommend.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neu.movie_recommend.common.Result;
import com.neu.movie_recommend.domain.Commodity;
import com.neu.movie_recommend.dao.ICommodityMapper;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author rzh
 * @date 2022/3/18 - 14:32
 */
@Api(tags = "所有电影")
@RestController
@AllArgsConstructor
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    ICommodityMapper iCommodityMapper;

    @GetMapping
    public Result<?> getAllCommodity(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "20") Integer pageSize,
                                     @RequestParam(defaultValue = "") String search){

        LambdaQueryWrapper<Commodity> wrapper = Wrappers.lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Commodity::getName, search);
        }
        Page<Commodity> page = iCommodityMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(page);
    }
}
