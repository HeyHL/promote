package io.hel.excep;

import io.hel.constants.Symbol;

/**
 * helei
 * 2021/11/9 11:37
 * description:
 */
@SuppressWarnings("all")
public class BusinessException extends Exception {

    private static final String APPLICATION = System.getProperty("spring.application.name");

    private static final String STRIKETHROUGH = Symbol.STRIKETHROUGH;

    /**
     * 状态码
     */
    protected String code;

    /**
     * 异常信息
     */
    protected String message;

    /**
     * 定位信息
     */
    protected String locate;

    /**
     * 异常分析
     */
    protected String analysis;

    public BusinessException() {
        this.locate = APPLICATION;
        this.analysis = "BE";
    }

    public String getCompleteCode() {
        return new StringBuilder().append(locate).append(STRIKETHROUGH).append(analysis).append(STRIKETHROUGH).append(code).toString().toUpperCase();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}
