package io.hel.mapper;

import io.hel.entity.OrderInfo;

import java.util.List;
import java.util.Map;

/**
 * helei
 * 2021/11/6 16:01
 * description:
 */
@SuppressWarnings("all")
public interface OrderInfoMapper {

    List<OrderInfo> selectByNameOrStatus(Map<String, Object> paramsMap);
}
