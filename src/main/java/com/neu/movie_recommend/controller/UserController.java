package com.neu.movie_recommend.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neu.movie_recommend.common.Result;
import com.neu.movie_recommend.dao.UserMapper;
import com.neu.movie_recommend.domain.Commodity;
import com.neu.movie_recommend.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author rzh
 * @date 2022/3/18 - 16:27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    /**
     *用户登陆的判断及跳转界面的方法
     */
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsercode,user.getUsercode()).eq(User::getPword,user.getPword()));
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success(res);
    }

    /**
     *注册方法
     */
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        user.setUrole("user");
        userMapper.insert(user);
        return Result.success(user);
    }
    /**
     * 更新用户方法
     */
    @PutMapping
    public Result<?> update(@RequestBody User user) {
        userMapper.updateById(user);
        return Result.success();
    }

    @GetMapping
    public Result<?> getUser(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "20") Integer pageSize){
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();

        wrapper.like(User::getUsercode, "");

        Page<User> page = userMapper.selectPage(new Page<User>(pageNum,pageSize),wrapper);

        return Result.success(page);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        userMapper.deleteById(id);
        return Result.success();
    }
}
