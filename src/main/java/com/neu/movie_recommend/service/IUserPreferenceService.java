package com.neu.movie_recommend.service;

import com.neu.movie_recommend.domain.UserPreference;

import java.util.List;

/**
 * @author rzh
 * @date 2022/3/18 - 23:15
 */
public interface IUserPreferenceService {
    /**
     * 获取所有用户偏好数据
     * @return 用户偏好数据
     */
    List<UserPreference> getAllUserPreference();
}
