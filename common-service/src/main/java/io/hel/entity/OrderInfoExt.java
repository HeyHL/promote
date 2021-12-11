package io.hel.entity;

import lombok.Data;

import java.util.Date;

/**
 * helei
 * 2021/10/9 19:16
 * description:
 */
@SuppressWarnings("all")
@Data
public class OrderInfoExt {
    private Integer id;

    private String orderId;

    private String attachInfo;

    private Date createTime;

}
