package com.sh.demo.common.result;

import java.util.HashMap;

/**
 * Created by wuminggu on 2018/4/19.
 */
public class ResultResponse<V> extends HashMap<String, Object> {
    protected static final String CODE = "code";
    protected static final String MSG = "msg";
    protected static final String DATA = "data";
    protected String dataKey;

    public ResultResponse(int code, String msg) {
        setCode(code);
        setMsg(msg);
    }
    public ResultResponse(ResultCodeEnum codeEnum) {
        setCode(codeEnum.getCode());
        setMsg(codeEnum.getMsg());
    }
    public ResultResponse(ResultCodeEnum codeEnum, String dataKey, V data) {
        this(codeEnum);
        setData(dataKey, data);
    }
    public ResultResponse(ResultCodeEnum codeEnum, V data) {
        this(codeEnum);
        setData(data);
    }

    public static ResultResponse success() {
        return new ResultResponse(ResultCodeEnum.DE_OK);
    }
    public static <V> ResultResponse<V> success(V data) {
        return new ResultResponse(ResultCodeEnum.DE_OK, data);
    }
    public static <V> ResultResponse<V> success(String key, V data) {
        return new ResultResponse(ResultCodeEnum.DE_OK, key, data);
    }

    public static ResultResponse failed(String msg) {
        return new ResultResponse(ResultCodeEnum.DE_SYS_ERR.getCode(), msg);
    }
    public static ResultResponse failed() {
        return new ResultResponse(ResultCodeEnum.DE_SYS_ERR);
    }
    public static ResultResponse failed(ResultCodeEnum codeEnum) {
        return new ResultResponse(codeEnum);
    }

    public int getCode() {
        return Integer.valueOf(get(CODE).toString()).intValue();
    }
    public void setCode(int code) {
        put(CODE, code);
    }
    public String getMsg() {
        return get(MSG).toString();
    }
    public void setMsg(String msg) {
        put(MSG, msg);
    }
    public V getData() {
        return get(dataKey) != null ? (V) get(dataKey) : null;
    }
    public void setData(V data) {
        setData(DATA, data);
    }
    public void setData(String dataKey, V data) {
        this.dataKey = dataKey;
        put(dataKey, data);
    }

    public boolean isSuccess() {
        return ResultCodeEnum.DE_OK.getCode() == getCode();
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        value.append('{').append(CODE).append('=').append(getCode())
                .append(", ").append(MSG).append("='").append(getMsg()).append('\'');

        if (dataKey != null) {
            value.append(", ").append(dataKey).append("='").append(getData()).append('\'');
        }
        value.append('}');
        return value.toString();
    }
}
