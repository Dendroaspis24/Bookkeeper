package com.dhh.bookkeeper.bookkeeper.Enum;

import com.dhh.bookkeeper.utils.BaseError;

public enum  ErrorCodeEnum implements EnumService {


    业务处理异常(10000, "业务处理异常"),
    该房间号已关闭(90001,"该房间号已关闭，无法加入！"),
    数据不存在(90001,"%s数据不存在")
    ;

    /** 错误码 */
    private Integer errorCode;

    /** 错误描述 */
    private String errorMsg;

    ErrorCodeEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public String getName() {
        return this.errorMsg;
    }

    @Override
    public int getValue() {
        return this.errorCode;
    }
}
