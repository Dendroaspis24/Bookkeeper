package com.dhh.bookkeeper.bookkeeper.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;


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
 * 
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("office_current_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficeCurrentInfo extends Model<OfficeCurrentInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 房间流水信息id
     */
    @TableId(value = "office_current_id", type = IdType.AUTO)
    private Long officeCurrentId;
    /**
     * 房间id
     */
    @TableField("office_id")
    private Long officeId;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 支出人
     */
    @TableField("from_user")
    private Long fromUser;
    /**
     * 收入人
     */
    @TableField("to_user")
    private Long toUser;
    /**
     * 记账时间
     */
    @TableField("trade_time")
    private Date tradeTime;


    @Override
    protected Serializable pkVal() {
        return this.officeCurrentId;
    }

}
