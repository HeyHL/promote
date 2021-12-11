package io.hel.controller;

import io.hel.vo.req.UpdateGoodsReqVO;
import io.hel.vo.resp.ResultVO;
import io.hel.vo.resp.UpdateGoodsRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helei
 * 2021/11/18 11:05
 * description:
 */
@SuppressWarnings("all")
@Slf4j
@RestController
@RequestMapping(value = "/ecmiddle/goods")
public class GoodsController {

    @PostMapping(value = "update")
    public ResultVO<UpdateGoodsRespVO> updateGoods(@RequestBody UpdateGoodsReqVO reqVO) throws Exception {

        return ResultVO.success();
    }

    @PostMapping(value = "getGoodsByPage")
    public ResultVO<String> getGoodsByPage() throws Exception {

        return ResultVO.success();
    }

}
