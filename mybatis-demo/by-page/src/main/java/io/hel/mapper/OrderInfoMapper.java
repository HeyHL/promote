package io.hel.mapper;

import io.hel.entity.OrderInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * helei
 * 2021/11/9 17:46
 * description:
 */
@SuppressWarnings("all")
public interface OrderInfoMapper {

    List<OrderInfo> selectByLimit(Map<String, Object> map);

    List<OrderInfo> selectByPage(Map<String, Object> map);

    List<OrderInfo> selectByPageHelper();

    List<OrderInfo> selectByRowBounds(RowBounds rowBounds);

    List<OrderInfo> selectByRowBoundsForNil();
}
