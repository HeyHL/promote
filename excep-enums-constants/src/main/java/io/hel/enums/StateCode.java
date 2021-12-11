package io.hel.enums;

/**
 * helei
 * 2021/11/9 13:57
 * description:
 */
@SuppressWarnings("all")
public enum StateCode {
    SUCCESS("00000", "请求成功"),
    UNKNOW("00000", "未知错误"),
    ;
    private String code;

    private String desc;

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    StateCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
