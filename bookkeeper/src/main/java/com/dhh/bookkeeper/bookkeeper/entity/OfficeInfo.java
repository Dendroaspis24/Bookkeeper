package com.dhh.bookkeeper.bookkeeper.entity;

import java.io.Serializable;
import java.util.Date;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 房间信息表
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("office_info")
public class OfficeInfo extends Model<OfficeInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 房间id
     */
    @TableId(value = "office_id", type = IdType.ID_WORKER_STR)
    private Long officeId;
    /**
     * 房间名称
     */
    @TableField("office_name")
    private String officeName;
    /**
     * 房间创建者
     */
    @TableField("creator_id")
    private Long creatorId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 房间状态
     */
    @TableField("office_status")
    private String officeStatus;
    /**
     * 房间人数总和
     */
    @TableField("emp_count")
    private Integer empCount;


    @Override
    protected Serializable pkVal() {
        return this.officeId;
    }

}
