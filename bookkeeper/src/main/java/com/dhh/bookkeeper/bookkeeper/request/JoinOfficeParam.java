package com.dhh.bookkeeper.bookkeeper.request;

import com.dhh.bookkeeper.utils.DataType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinOfficeParam implements Serializable {

    @ApiModelProperty(value = "房间号码", dataType = DataType.String)
    @NotNull(message = "房间号码不可为空")
    private String officeNum;

    @ApiModelProperty(value = "用户姓名", dataType = DataType.List)
    @NotNull(message = "用户姓名不可为空")
    private String userName;

    @ApiModelProperty(value = "openId", dataType = DataType.Integer)
    @NotNull(message = "openId不可为空")
    private String openId;

    @ApiModelProperty(value = "微信账号", dataType = DataType.Integer)
    @NotNull(message = "微信账号不可为空")
    private String wxCode;
}
