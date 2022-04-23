package com.neu.movie_recommend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.movie_recommend.domain.Commodity;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rzh
 * @date 2022/3/18 - 22:43
 */
@Repository
public interface ICommodityMapper extends BaseMapper<Commodity> {
    /**
     * 查询所有商品数据
     * @return 所有商品数据
     */
    @SelectProvider(type = CommoditySql.class, method = "findAllByIds")
    List<Commodity> findAllByIds();

    final class CommoditySql {
        public String findAllByIds() {
            return new SQL() {{
                SELECT("c.pid", "c.name", "c.types");
                FROM("commodity as c");
            }}.toString();
        }
    }
}
