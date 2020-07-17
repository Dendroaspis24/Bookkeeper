package com.dhh.bookkeeper.bookkeeper.entity;

import java.io.Serializable;
import java.util.Date;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficeInfo extends Model<OfficeInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 房间id
     */
    @TableId(value = "office_id", type = IdType.AUTO)
    private Long officeId;
    /**
     * 房间名称
     */
    @TableField("office_num")
    private String officeNum;
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
    private Integer officeStatus;
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
