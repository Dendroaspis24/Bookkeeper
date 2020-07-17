package com.dhh.bookkeeper.bookkeeper.Enum;

import java.util.HashMap;
import java.util.Map;

/**
 * 房间状态枚举类
 */
public enum OfficeStatusEnum {
    已关闭_0(0, "已关闭"),
    开启中_1(1, "开启中");

    private Integer value;
    private String text;

    private static final Map<Integer, OfficeStatusEnum> map = new HashMap(values().length);

    static {
        for (OfficeStatusEnum instance : values()) {
            map.put(instance.value(), instance);
        }
    }

    OfficeStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 根据编码获取枚举
     *
     * @param value
     * @return
     */
    public static OfficeStatusEnum of(Integer value) {
        return map.get(value);
    }

    public Integer value() {
        return this.value;
    }

    public String text() {
        return this.text;
    }
}
