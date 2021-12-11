package io.hel.vo.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * helei
 * 2021/11/18 11:03
 * description:
 */
@SuppressWarnings("all")
@Data
public class UpdateGoodsReqVO implements Serializable {


    @NotNull(message = "spuId cannot null")
    private Long spuId;

    @NotEmpty(message = "spuName cannot empty")
    private String spuName;

}
