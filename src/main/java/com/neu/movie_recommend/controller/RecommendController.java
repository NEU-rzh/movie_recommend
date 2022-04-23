package com.neu.movie_recommend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neu.movie_recommend.common.Result;
import com.neu.movie_recommend.service.IRecommendService;
import lombok.AllArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rzh
 * @date 2022/3/18 - 8:42
 */
@Api(tags = "推荐商品")
@RestController
@AllArgsConstructor
@RequestMapping("/recommend")
public class RecommendController {
    private final IRecommendService iRecommendService;

    @ApiOperation(value = "基于用户的推荐")
    @GetMapping("/user")
    public Result<?> getRecommendCommodityByUser(@RequestParam("userId") Long userId,
                                                 @RequestParam("count") Integer count,
                                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize) throws TasteException {

        return Result.success(iRecommendService.getRecommendCommodityByUser(new Page<>(pageNum,pageSize),userId,count));
    }

    @ApiOperation(value = "基于电影的推荐")
    @GetMapping("/commodity")
    public Result<?> getRecommendCommodityByCommodity(@RequestParam("userId") Long userId,
                                                                    @RequestParam("commodityId") Long commodityId,
                                                                    @RequestParam("count") Integer count,
                                                                    @RequestParam(defaultValue = "1") Integer pageNum,
                                                                    @RequestParam(defaultValue = "10") Integer pageSize) throws TasteException {
        return Result.success(iRecommendService.getRecommendCommodityByCommodity(pageNum,pageSize,userId,commodityId,count));
    }

}
