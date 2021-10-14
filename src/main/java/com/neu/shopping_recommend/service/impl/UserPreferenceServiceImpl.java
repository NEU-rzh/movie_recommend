package com.neu.shopping_recommend.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.shopping_recommend.dao.IUserPreferenceMapper;
import com.neu.shopping_recommend.domain.UserPreference;
import com.neu.shopping_recommend.service.IUserPreferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rzh
 * @date 2021/10/12 - 23:35
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
