package io.hel.service;

import io.hel.entity.OrderInfo;

/**
 * helei
 * 2021/10/9 19:40
 * description:
 */
@SuppressWarnings("all")
public interface OrderBizService {

    void createOrder() throws Exception;

    OrderInfo getOrderInfo(int id) throws Exception;
}
