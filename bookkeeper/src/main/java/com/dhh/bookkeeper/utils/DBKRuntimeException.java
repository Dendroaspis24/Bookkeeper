package com.dhh.bookkeeper.utils;

import com.dhh.bookkeeper.bookkeeper.Enum.EnumService;
import com.dhh.bookkeeper.bookkeeper.Enum.ErrorCodeEnum;
import org.apache.commons.lang3.StringUtils;

public class DBKRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -2008958940060983230L;
    private Integer code;

    public DBKRuntimeException(String s) {
        super(s);
        this.code = ErrorCodeEnum.业务处理异常.getErrorCode();
    }

    public DBKRuntimeException(EnumService enumService) {
        super(enumService.getName());
        this.code = enumService.getValue();
    }

    public DBKRuntimeException(int code, String s) {
        super(s);
        this.code = code;
    }

    public static void ifThrow(boolean is, EnumService enumService) {
        ifThrow(is, enumService, null);
    }

    public static void ifThrow(boolean is, EnumService enumService, Object... args) {
        if (is) {
            String name = enumService.getName();
            if (StringUtils.isNotBlank(name) && args != null) {
                name = String.format(name, args);
            }
            throw new DBKRuntimeException(enumService.getValue(), name);
        }
    }

    public static void ifThrow(boolean is, String msg) {
        if (is) {
            throw new DBKRuntimeException(msg);
        }
    }

    public static void ifThrow(boolean is, int code, String msg) {
        if (is) {
            throw new DBKRuntimeException(code, msg);
        }
    }
}
