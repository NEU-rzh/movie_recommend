package com.neu.movie_recommend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author rzh
 * @date 2022/3/18 - 16:24
 */
@TableName("user_tab")
@Data
public class User {
    @TableId(value="uid",type= IdType.AUTO)
    private int uid;
    private String usercode;
    private String pword;
    private String uname;
    private String urole;
}
