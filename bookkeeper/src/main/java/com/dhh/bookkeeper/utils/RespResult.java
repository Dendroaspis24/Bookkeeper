package com.dhh.bookkeeper.utils;

import com.dhh.bookkeeper.bookkeeper.Enum.EnumService;
import com.dhh.bookkeeper.bookkeeper.Enum.RespEnum;

import java.io.Serializable;

public class RespResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code = RespEnum.success.getValue();
    private String message = RespEnum.success.getName();
    private boolean status = true;
    private T data;

    /**
     * 通过枚举获取RespResult
     * @param enumEntity
     * @return
     */
    public static RespResult<String> successEnum(EnumService enumEntity) {
        return RespResult.success(enumEntity.getValue(), enumEntity.getName());
    }

    /**
     * 通过枚举获取RespResult
     * @param enumEntity
     * @return
     */
    public static <T> RespResult<T> successEnum(EnumService enumEntity, T obj) {
        return RespResult.success(enumEntity.getValue(), enumEntity.getName(),obj);
    }

    /**
     * 通过枚举获取RespResult
     * @param enumEntity
     * @return
     */
    public static RespResult<String> failureEnum(EnumService enumEntity) {
        return RespResult.failure(enumEntity.getValue(), enumEntity.getName());
    }

    /**
     * 通过枚举获取RespResult
     * @param enumEntity
     * @return
     */
    public static <T> RespResult<T> failureEnum(EnumService enumEntity, T obj) {
        return RespResult.failure(enumEntity.getValue(), enumEntity.getName(),obj);
    }


    /**
     *构建成功结果
     * @return
     */
    public static RespResult<String> success() {
        return new RespResult<String>();
    }

    /**
     *构建成功结果
     * @return
     */
    public static RespResult<String> success(boolean res) {
        return res?success():failure();
    }
    /**
     *构建成功结果
     * @return
     */
    public static <T> RespResult<T> success(T data) {
        return new RespResult<T>(data);
    }
    /**
     *构建成功结果
     * @param code
     * @param message
     * @return
     */
    public static RespResult<String> success(int code, String message) {
        return new RespResult<String>(code,message );
    }

    /**
     *构建成功结果
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static <T> RespResult<T> success(int code, String message, T data) {
        return new RespResult<T>(true,code,message,data );
    }


    /**
     * 构建失败结果
     * @return
     */
    public static RespResult<String> failure(){
        return new RespResult<String>(false,RespEnum.failure.getValue(),RespEnum.failure.getName() );
    }
    /**
     * 构建失败结果
     * @param message
     * @return
     */
    public static RespResult<String> failure(String message){
        return new RespResult<String>(false,RespEnum.failure.getValue(),message);
    }
    /**
     * 构建失败结果
     * @param message
     * @return
     */
    public static <T> RespResult<T> failure(T data){
        return new RespResult<T>(false,RespEnum.failure.getValue(),RespEnum.failure.getName(),data);
    }
    /**
     * 构建失败结果
     * @param code
     * @param message
     * @return
     */
    public static RespResult<String> failure(int code, String message){
        return new RespResult<String>(false,code,message );
    }
    /**
     * 构建失败结果
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static <T> RespResult<T> failure(int code, String message, T data){
        return new RespResult<T>(false,code,message,data );
    }

    public RespResult(Boolean status, int code, String message) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
    }
    public RespResult(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public RespResult() {
    }
    public RespResult(Boolean status, int code, String message, T data) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public RespResult(T data) {
        super();
        this.data = data;
    }
    public RespResult(RespEnum  respEnum) {
        this.code = respEnum.getValue();
        this.message = respEnum.getName();
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}
