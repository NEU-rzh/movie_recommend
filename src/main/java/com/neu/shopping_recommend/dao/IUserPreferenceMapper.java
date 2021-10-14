package com.neu.shopping_recommend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.shopping_recommend.domain.UserPreference;
import org.springframework.stereotype.Repository;

/**
 * @author rzh
 * @date 2021/10/12 - 22:44
 */
@Repository
public interface IUserPreferenceMapper extends BaseMapper<UserPreference> {
}
