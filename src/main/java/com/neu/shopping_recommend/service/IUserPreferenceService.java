package com.neu.shopping_recommend.service;

import com.neu.shopping_recommend.domain.UserPreference;

import java.util.List;

/**
 * @author rzh
 * @date 2021/10/12 - 23:15
 */
public interface IUserPreferenceService {
    /**
     * 获取所有用户偏好数据
     * @return 用户偏好数据
     */
    List<UserPreference> getAllUserPreference();
}
