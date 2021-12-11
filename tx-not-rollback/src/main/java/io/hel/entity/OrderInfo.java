package io.hel.entity;

import lombok.Data;

import java.util.Date;

/**
 * helei
 * 2021/10/9 13:35
 * description:
 */
@SuppressWarnings("all")
@Data
public class OrderInfo {

    private Integer id;

    private String orderId;

    private String orderName;

    private Date createTime;
}
