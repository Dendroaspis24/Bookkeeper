package com.dhh.bookkeeper.bookkeeper.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 人员房间关联表
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_office_mapping")
public class UserOfficeMapping extends Model<UserOfficeMapping> {

    private static final long serialVersionUID = 1L;

    /**
     * 人员房间关联id
     */
    @TableId(value = "user_office_id", type = IdType.ID_WORKER_STR)
    private Long userOfficeId;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 房间id
     */
    @TableField("office_id")
    private Long officeId;


    @Override
    protected Serializable pkVal() {
        return this.userOfficeId;
    }

}
