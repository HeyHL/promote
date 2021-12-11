package io.hel.service.impl;

import io.hel.entity.OrderInfo;
import io.hel.entity.OrderInfoExt;
import io.hel.mapper.OrderInfoExtMapper;
import io.hel.mapper.OrderInfoMapper;
import io.hel.service.OrderBizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * helei
 * 2021/10/9 19:50
 * description:
 */
@SuppressWarnings("all")
@Service
@Slf4j
public class OrderBizServiceImpl implements OrderBizService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderInfoExtMapper orderInfoExtMapper;

    // 自己注入自己
    @Autowired
    private OrderBizServiceImpl orderBizService;

    // 从ioc容器中拿代理对象
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Transactional
    public OrderInfo getOrderInfo(int id) throws Exception {
        return orderInfoMapper.selectById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createOrder() throws Exception {
        String orderId = UUID.randomUUID().toString().replaceAll("-", "").toString();
        try {
//            OrderBizServiceImpl orderBizServiceImpl = applicationContext.getBean("orderBizServiceImpl", OrderBizServiceImpl.class);
            // 获取暴露出来的代理对象 @EnableAspectJAutoProxy(exposeProxy = true)
//            OrderBizServiceImpl orderBizServiceImpl = (OrderBizServiceImpl)AopContext.currentProxy();
//            orderBizServiceImpl.orderExt(orderId);
            orderBizService.orderExt(orderId);
        } catch (Exception e) {
            log.info("#######OrderBizServiceImpl.createOrder.excep --> {}", e.getMessage());
//            throw e;
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(orderId);
        orderInfo.setOrderName("hel");
        orderInfo.setCreateTime(new Date());
        int res = orderInfoMapper.insertOrderInfo(orderInfo);
        log.info("########OrderBizServiceImpl.order.res --> {}", res);
        if (res < 1) {
            throw new RuntimeException();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void orderExt(String orderId) throws Exception {
        OrderInfoExt orderInfoExt = new OrderInfoExt();
        orderInfoExt.setOrderId(orderId);
        orderInfoExt.setAttachInfo("hello");
        orderInfoExt.setCreateTime(new Date());
        int res = orderInfoExtMapper.insertOrderInfoExt(orderInfoExt);
        log.info("############OrderBizServiceImpl.orderExt.res --> {}", res);
        if (res < 1) {
            throw new RuntimeException();
        }
        int i = 10 / 0;
    }
}
