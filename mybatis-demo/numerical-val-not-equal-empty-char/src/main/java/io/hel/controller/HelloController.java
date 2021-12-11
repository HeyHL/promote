package io.hel.controller;

import io.hel.aop.anno.AroundLog;
import io.hel.entity.OrderInfo;
import io.hel.mapper.OrderInfoMapper;
import io.hel.vo.req.GetOrderInfoReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * helei
 * 2021/11/10 10:40
 * description:
 */
@SuppressWarnings("all")
@RestController
@RequestMapping(value = "hello")
@AroundLog
public class HelloController {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @PostMapping(value = "m1")
    public String m1(@RequestBody GetOrderInfoReqVO reqVO) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("orderName", reqVO.getOrderName());
        paramsMap.put("orderStatus", reqVO.getOrderStatus());
        List<OrderInfo> orderInfos = orderInfoMapper.selectByNameOrStatus(paramsMap);
        return null;
    }

}
