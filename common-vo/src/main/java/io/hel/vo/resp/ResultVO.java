package io.hel.vo.resp;

import io.hel.excep.BusinessException;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * helei
 * 2021/11/18 11:14
 * description:
 * 接口基本响应实体
 */
@SuppressWarnings("all")
@Data
@ToString
public class ResultVO<T> implements Serializable {

    private static final String SUCCESS_CODE = "00000";

    private static final String SUCCESS_MESSAGE = "请求成功!";

    private String code;

    private T data;

    private String msg;

    private Long timestamp = System.currentTimeMillis();

    private String trace;

    public ResultVO(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(BusinessException exception) {
        this.code = exception.getCode();
        this.msg = exception.getMessage();
        this.data = null;
        this.trace = exception.getCompleteCode();
    }

    public static ResultVO success(Object data) {
        return new ResultVO(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static ResultVO success() {
        return new ResultVO(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static ResultVO error(BusinessException exception) {
        return new ResultVO(exception);
    }

    public static ResultVO error(String code, String msg) {
        return new ResultVO(code, msg, null);
    }

}
