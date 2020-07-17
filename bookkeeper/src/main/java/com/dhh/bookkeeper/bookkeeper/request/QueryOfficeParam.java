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
public class QueryOfficeParam implements Serializable {

    @ApiModelProperty(value = "房间状态(0:已关闭，1：已开启)", dataType = DataType.List)
    @NotNull(message = "用户姓名不可为空")
    private Integer officeStatus;

}
