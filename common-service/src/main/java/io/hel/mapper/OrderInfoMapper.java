package io.hel.mapper;

import io.hel.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * helei
 * 2021/11/10 11:32
 * description:
 */
@SuppressWarnings("all")
public interface OrderInfoMapper {

    OrderInfo selectById(@Param("id") int id);

    int insertOrderInfo(OrderInfo orderInfo);

    OrderInfo selectDetailById(@Param("id") int id);
}
