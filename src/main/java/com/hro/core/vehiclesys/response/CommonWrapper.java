package com.hro.core.vehiclesys.response;

import java.io.Serializable;

/**
 * Http 响应消息体父类
 */
public class CommonWrapper implements Serializable{
    /**
     * 状态码
     */
    public int resultCode;

    /**
     * 处理结果
     */
    public String resultMsg;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
