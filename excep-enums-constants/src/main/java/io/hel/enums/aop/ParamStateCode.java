package io.hel.enums.aop;

import io.hel.excep.BusinessException;

/**
 * helei
 * 2021/11/9 14:27
 * description:
 */
@SuppressWarnings("all")
public enum ParamStateCode {
    INVALID("01001", "参数验证失败"),
    ;
    private String code;

    private String desc;

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    ParamStateCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public BusinessException toBusinessException() {
        BusinessException businessException = new BusinessException();
        businessException.setCode(this.code);
        businessException.setMessage(this.desc);
        return businessException;
    }

    public BusinessException toBusinessException(String extra) {
        BusinessException businessException = new BusinessException();
        businessException.setCode(this.code);
        businessException.setMessage(this.desc + "-->" + extra);
        return businessException;
    }
}
