package com.neu.movie_recommend.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.movie_recommend.domain.UserPreference;
import com.neu.movie_recommend.dao.IUserPreferenceMapper;
import com.neu.movie_recommend.service.IUserPreferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rzh
 * @date 2022/3/18 - 23:35
 */
@Service
@AllArgsConstructor
public class UserPreferenceServiceImpl implements IUserPreferenceService {
    private final IUserPreferenceMapper iUserPreferenceMapper;

    @Override
    public List<UserPreference> getAllUserPreference() {
        return iUserPreferenceMapper.selectList(Wrappers.emptyWrapper());
    }
}
