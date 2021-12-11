package io.hel.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * helei
 * 2021/11/18 11:27
 * description:
 */
@SuppressWarnings("all")
@Data
@ApiModel(value = "分页响应实体")
public class PageRespVO<T> implements Serializable {

    @ApiModelProperty(value = "总记录数")
    private Integer total;

    @ApiModelProperty(value = "数据集合")
    private List<T> dataList;

}
