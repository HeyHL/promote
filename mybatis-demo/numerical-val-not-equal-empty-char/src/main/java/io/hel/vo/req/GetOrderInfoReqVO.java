package io.hel.vo.req;

import lombok.Data;

/**
 * helei
 * 2021/11/10 10:38
 * description:
 */
@SuppressWarnings("all")
@Data
public class GetOrderInfoReqVO {

    private String orderName;

    private Integer orderStatus;
}
