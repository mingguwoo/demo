package com.sh.demo.common.result;

/**
 * Created by wuminggu on 2018/4/19.
 */
public enum  ResultCodeEnum {
    DE_OK(0, "success"),
    DE_FALSE(0, "false"),
    DE_SYS_ERR(-1, "system error");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
