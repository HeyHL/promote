package io.hel.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * helei
 * 2021/11/18 11:14
 * description:
 */
@SuppressWarnings("all")
@Data
@ToString
@ApiModel(value = "分页请求实体")
public class PageReqVO<T> implements Serializable {

    @ApiModelProperty(value = "页码")
    @Min(value = 1, message = "页码最小为1")
    private Integer page = 1;

    @ApiModelProperty(value = "每页记录数")
    @Min(value = 1, message = "每页最少1页")
    private Integer rows = 10;

    @ApiModelProperty(value = "业务接口请求对象")
    private T reqVO;

}
