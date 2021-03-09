package cn.enums;

import java.util.Arrays;

/**
 * @Description 返回响应码
 * @Author myf
 * @CreateDate 2020/11/10 10:41
 * @Version 1.0
 **/
public enum ResponseCode {
    REQUEST_FAIL("0","请求失败"),
    REQUEST_SUCCESS("1","请求成功")
    ;


    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 判断是否存在该响应码
     * @param code
     * @return
     */
    public static boolean containedCode(String code){
        for (ResponseCode responseCode:ResponseCode.values()) {
            if (responseCode.getCode().equals(code)) {
                return true;
            }
        }
        return  false;
    }

    /**
     * 根据code获取对应的ResponseCode对象
     * @param code
     * @return
     */
    public static ResponseCode getResponseMessageByCode(String code) {
        for (ResponseCode responseCode:ResponseCode.values()) {
            if (responseCode.getCode().equals(code)) {
                return responseCode;
            }
        }
        return  null;
    }
}
