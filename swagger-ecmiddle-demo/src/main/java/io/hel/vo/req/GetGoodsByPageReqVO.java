package io.hel.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * helei
 * 2021/11/18 14:06
 * description:
 */
@SuppressWarnings("all")
@Data
@ApiModel(value = "查询商品请求实体")
public class GetGoodsByPageReqVO implements Serializable {

    @ApiModelProperty(value = "商品名称")

    private String spuName;

    @ApiModelProperty(value = "")
    private String spuCode;

}
