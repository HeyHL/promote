package io.hel.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.hel.aop.anno.AroundLog;
import io.hel.entity.OrderInfo;
import io.hel.mapper.OrderInfoMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * helei
 * 2021/11/9 17:48
 * description:
 */
@SuppressWarnings("all")
@RestController
@RequestMapping(value = "hello")
@AroundLog
public class HelloController {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostMapping(value = "m1")
    public List<OrderInfo> m1() {
        pageByMyInterceptor();
//        pageByPageHelper();
//        pageHelperSupportRowBounds();
        return null;
    }

    private void pageByLimit() {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("offset", 0);
        paramsMap.put("size", 1);
        List<OrderInfo> orderInfos = orderInfoMapper.selectByLimit(paramsMap);
    }

    private void pageByMyInterceptor() {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("page", 1);
        paramsMap.put("size", 1);
        List<OrderInfo> orderInfos1 = orderInfoMapper.selectByPage(paramsMap);
    }

    private void pageByPageHelper() {
        int page = 1;
        int size = 1;
        Page<OrderInfo> orderInfos2 = PageHelper.startPage(page, size);
        orderInfoMapper.selectByPageHelper();
    }

    private void pageHelperSupportRowBounds() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RowBounds rowBounds = new RowBounds(1, 1);
        orderInfoMapper.selectByRowBounds(rowBounds);
//        sqlSession.selectList("io.hel.mapper.OrderInfoMapper.selectByRowBoundsForNil", null, rowBounds);
    }
}
