package com.rcloud.spellutils.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 返回结果
 *
 * @author xucg
 * @date 2017/11/8
 */
public class ResultJson {
    //调用成功
    public static final Boolean SUCCESS_TRUE = true;
    //调用失败
    public static final Boolean SUCCESS_FALSE = false;

    //状态码
    public static final Integer CODE_0 = 1000;
    public static final Integer CODE_1 = 1001;
    public static final Integer CODE_2 = 1002;
    public static final Integer CODE_3 = 1003;
    public static final Integer CODE_4 = 1004;
    public static final Integer CODE_5 = 1005;
    public static final Integer CODE_6 = 1006;
    public static final Integer CODE_7 = 1007;
    public static final Integer CODE_8 = 1008;
    public static final Integer CODE_9 = 1009;
    public static final Integer CODE_10 = 1010;

    /**
     * 操作异常
     */
    public static final Integer CURRENCY_EXCEPTION = -0;
    /**
     * 登录异常
     */
    public static final Integer CHECK_LOGIN_EXCEPTION = -1;
    /**
     * 参数异常
     */
    public static final Integer ARGS_EXCEPTION = -2;

    //返回
    public static final String MSG_SUCCESS = "SUCCESS";
    public static final String MSG_FAIL = "FAIL";
    public static final String MSG_ERROR = "ERROR";


    public static final String INFO_EMPTY_STRING = "";
    public static final String INFO_INVALID = null;

    private boolean success;
    private Integer code;
    private String message;
    private Object info;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    /**
     * 自定义
     *
     * @param success
     * @param code
     * @param message
     * @param info
     * @return
     */
    public static String getResultJson(Boolean success, Integer code, String message, Object info) {
        return buildResult(success, code, message, info);
    }

    /**
     * 调用成功
     * 返回成功
     *
     * @return
     */
    public static String getResultJsonSuccess() {
        return buildResult(SUCCESS_TRUE, CODE_1, MSG_SUCCESS, INFO_EMPTY_STRING);
    }

    /**
     * 调用成功
     * 返回成功
     * 自定义返回数据
     *
     * @param info
     * @return
     */
    public static String getResultJsonSuccess(Object info) {
        return buildResult(SUCCESS_TRUE, CODE_1, MSG_SUCCESS, info);
    }

    /**
     * 调用成功
     * 返回成功
     * 自定义返回状态码
     * 自定义返回信息
     *
     * @param code
     * @param message
     * @return
     */
    public static String getResultJsonSuccess(Integer code, String message) {
        return buildResult(SUCCESS_TRUE, code, message, INFO_EMPTY_STRING);
    }

    /**
     * 调用成功
     * 返回成功
     * 自定义返回状态码
     * 自定义返回数据
     *
     * @param code
     * @param info
     * @return
     */
    public static String getResultJsonSuccess(Integer code, Object info) {
        return buildResult(SUCCESS_TRUE, code, MSG_SUCCESS, info);
    }

    /**
     * 调用成功
     * 返回成功
     * 自定义返回状态码
     * 自定义返回信息
     * 自定义返回数据
     *
     * @param code
     * @param message
     * @param info
     * @return
     */
    public static String getResultJsonSuccess(Integer code, String message, Object info) {
        return buildResult(SUCCESS_TRUE, code, message, info);
    }

    /**
     * 调用成功
     * 返回成功
     * 自定义返回信息
     * 自定义返回数据
     *
     * @param message
     * @param info
     * @return
     */
    public static String getResultJsonSuccess(String message, Object info) {
        return buildResult(SUCCESS_TRUE, CODE_1, message, info);
    }

    /**
     * 自定义返回信息
     *
     * @param message
     * @return
     */
    public static String getResultJsonSuccess(String message) {
        return buildResult(SUCCESS_TRUE, CODE_1, message, INFO_EMPTY_STRING);
    }

    /**
     * 调用成功
     * 返回失败
     *
     * @return
     */
    public static String getResultJsonFail() {
        return buildResult(SUCCESS_TRUE, CODE_2, MSG_FAIL, INFO_EMPTY_STRING);
    }

    /**
     * 调用成功
     * 返回失败
     * 自定义返回信息
     *
     * @param message
     * @return
     */
    public static String getResultJsonFail(String message) {
        return buildResult(SUCCESS_TRUE, CODE_2, message, INFO_EMPTY_STRING);
    }


    /**
     * 调用成功
     * 返回失败
     * 自定义返回信息
     * 自定义返回数据
     *
     * @param message
     * @param info
     * @return
     */
    public static String getResultJsonFail(String message, Object info) {
        return buildResult(SUCCESS_TRUE, CODE_2, message, info);
    }

    /**
     * 调用成功
     * 返回失败
     * 自定义返回信息
     * 自定义返回数据
     *
     * @param code
     * @param message
     * @return
     */
    public static String getResultJsonFail(Integer code, String message) {
        return buildResult(SUCCESS_TRUE, code, message, INFO_EMPTY_STRING);
    }


    /**
     * 返回数据
     *
     * @param info
     * @return
     */
    public static String getResultJsonFail(Object info) {
        return buildResult(SUCCESS_TRUE, CODE_2, MSG_FAIL, info);
    }

    /**
     * 调用成功
     * 返回失败
     * 自定义返回状态码
     * 自定义返回信息
     * 自定义返回数据
     *
     * @param code
     * @param message
     * @param info
     * @return
     */
    public static String getResultJsonFail(Integer code, String message, Object info) {
        return buildResult(SUCCESS_TRUE, code, message, info);
    }

    /**
     * 调用失败
     * 返回系统错误
     *
     * @return
     */
    public static String getResultJsonError() {
        return buildResult(SUCCESS_FALSE, CODE_0, MSG_ERROR, INFO_EMPTY_STRING);
    }

    /**
     * 调用失败
     * 返回失败
     * 自定义返回状态码
     *
     * @param code
     * @return
     */
    public static String getResultJsonError(Integer code) {
        return buildResult(SUCCESS_FALSE, CODE_0, MSG_ERROR, INFO_EMPTY_STRING);
    }


    /**
     * 调用失败
     * 返回失败
     * 自定义返回状态码
     * 自定义返回信息
     *
     * @param code
     * @return
     */
    public static String getResultJsonError(Integer code, String message) {
        return buildResult(SUCCESS_FALSE, code, message, INFO_EMPTY_STRING);
    }

    /**
     * 调用失败
     * 返回失败
     * 自定义返回状态码
     * 自定义返回数据
     *
     * @param code
     * @return
     */
    public static String getResultJsonError(Integer code, Object info) {
        return buildResult(SUCCESS_FALSE, code, MSG_ERROR, info);
    }

    /**
     * 调用失败
     * 返回失败
     * 自定义返回状态码
     * 自定义返回信息
     * 自定义返回数据
     *
     * @param message
     * @return
     */
    public static String getResultJsonError(String message, Object info) {
        return buildResult(SUCCESS_FALSE, CODE_0, message, info);
    }

    /**
     * 调用失败
     * 返回失败
     * 自定义返回状态码
     * 自定义返回信息
     * 自定义返回数据
     *
     * @param code
     * @return
     */
    public static String getResultJsonError(Integer code, String message, Object info) {
        return buildResult(SUCCESS_FALSE, code, message, info);
    }


    /**
     * build实体类
     *
     * @param success
     * @param code
     * @param message
     * @param info
     * @return
     */
    public static String buildResult(Boolean success, Integer code, String message, Object info) {
        ResultJson resultJson = new ResultJson();
        resultJson.setSuccess(success);
        resultJson.setCode(code);
        resultJson.setMessage(message);
        resultJson.setInfo(info);
        return JSONObject.toJSONString(resultJson, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
    }
}
