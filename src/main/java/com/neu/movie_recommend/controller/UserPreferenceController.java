package com.neu.movie_recommend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.movie_recommend.common.Result;
import com.neu.movie_recommend.domain.UserPreference;
import com.neu.movie_recommend.dao.IUserPreferenceMapper;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * @author rzh
 * @date 2021/10/20 - 21:48
 */
@RestController
@RequestMapping("/userpreference")
public class UserPreferenceController {
    @Resource
    IUserPreferenceMapper iUserPreferenceMapper;

    @PutMapping
    public Result<?> update(@RequestBody UserPreference userPreference) {
        LambdaQueryWrapper<UserPreference> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserPreference::getPid,userPreference.getPid()).eq(UserPreference::getUid,userPreference.getUid());
        if(iUserPreferenceMapper.selectOne(wrapper) == null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            userPreference.setTime(df.format(System.currentTimeMillis()));
            iUserPreferenceMapper.insert(userPreference);
        }else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            userPreference.setTime(df.format(System.currentTimeMillis()));
            iUserPreferenceMapper.update(userPreference,wrapper);
        }
        return Result.success();
    }
}
