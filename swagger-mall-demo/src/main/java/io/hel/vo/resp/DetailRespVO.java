package io.hel.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * helei
 * 2021/11/15 11:46
 * description:
 */
@SuppressWarnings("all")
@Data
@ApiModel(value = "detail查询响应实体")
public class DetailRespVO implements Serializable {

    @ApiModelProperty(value = "标题")
    private String title;
}
