package com.neu.shopping_recommend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author rzh
 * @date 2021/10/12 - 16:37
 */
@Data
@TableName("user_preference")
public class UserPreference {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    private Long uid;
    /**
     * 商品id
     */
    private Long pid;
    /**
     * 偏好值 最大值5
     */
    private Long val;

    private LocalDateTime time;
}
