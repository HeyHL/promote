package io.hel.controller;

import io.hel.aop.anno.AroundLog;
import io.hel.entity.OrderInfo;
import io.hel.service.OrderBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helei
 * 2021/11/10 11:30
 * description:
 */
@SuppressWarnings("all")
@RestController
@RequestMapping(value = "hello")
@AroundLog
public class HelloController {

    @Autowired
    private OrderBizService orderBizService;


    @PostMapping(value = "test1/{id}")
    public OrderInfo test1(@PathVariable("id") int id) throws Exception {
        OrderInfo orderInfo = orderBizService.getOrderInfo(id);
        return orderInfo;
    }

    @PostMapping(value = "createOrder")
    public String createOrder() throws Exception {
        orderBizService.createOrder();
        return "success";
    }
}
