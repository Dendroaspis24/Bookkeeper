package com.dhh.bookkeeper.bookkeeper.request;

import com.dhh.bookkeeper.utils.DataType;
import com.sun.xml.internal.ws.api.message.Message;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOfficeParam implements Serializable {

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
