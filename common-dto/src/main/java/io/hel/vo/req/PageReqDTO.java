package io.hel.vo.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * helei
 * 2021/11/18 11:31
 * description:
 */
@SuppressWarnings("all")
@Data
@ApiModel(value = "分页请求DTO")
public class PageReqDTO<T> implements Serializable {

    /** 页码 */
    private Integer page = 1;

    /** 每页记录数 */
    private Integer rows = 10;

    /** rpc请求对象 */
    private T reqDTO;
}
