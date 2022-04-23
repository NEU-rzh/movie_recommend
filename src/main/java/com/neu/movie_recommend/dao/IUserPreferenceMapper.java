package com.neu.movie_recommend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.movie_recommend.domain.UserPreference;
import org.springframework.stereotype.Repository;

/**
 * @author rzh
 * @date 2022/3/18 - 22:44
 */
@Repository
public interface IUserPreferenceMapper extends BaseMapper<UserPreference> {
}
