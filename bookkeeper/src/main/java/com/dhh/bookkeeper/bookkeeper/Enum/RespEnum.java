package com.dhh.bookkeeper.bookkeeper.Enum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum RespEnum implements EnumService{
    success(200,"ok"),
    failure(500,"failure");


    /** 描述  */
    private String name;
    /** 枚举值 */
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private RespEnum(int value,String name ){
        this.name = name;
        this.value = value;
    }

    public static RespEnum getEnum(int value){
        RespEnum resultEnum = null;
        RespEnum[] enumAry = RespEnum.values();
        for(int i = 0;i<enumAry.length;i++){
            if(enumAry[i].getValue() == value){
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List toList(){
        RespEnum[] ary = RespEnum.values();
        List list = new ArrayList();
        for(int i=0;i<ary.length;i++){
            Map<String,String> map = new HashMap<String,String>();
            map.put("value",String.valueOf(ary[i].getValue()));
            map.put("name", ary[i].getName());
            list.add(map);
        }
        return list;
    }

    public static Map<String, Map<String, Object>> toMap() {
        RespEnum[] ary = RespEnum.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = String.valueOf(getEnum(ary[num].getValue()));
            map.put("value", String.valueOf(ary[num].getValue()));
            map.put("name", ary[num].getName());
            enumMap.put(key,map);
        }
        return enumMap;
    }
}