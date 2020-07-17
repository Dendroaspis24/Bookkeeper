package com.dhh.bookkeeper.bookkeeper.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 最近一次登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 登录状态（0：未登录，1：登陆中）
     */
    @TableField("login_flag")
    private String loginFlag;

    /**
     *用户openId
     */
    @TableField("open_id")
    private String openId;

    /**
     * 用户微信账号
     */
    @TableField("wx_code")
    private String wxCode;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
