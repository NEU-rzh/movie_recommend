package com.neu.movie_recommend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author rzh
 * @date 2022/3/18 - 16:36
 */
@Data
@TableName("commodity")
public class Commodity {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Long pid;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品类型
     */
    private String types;
}
