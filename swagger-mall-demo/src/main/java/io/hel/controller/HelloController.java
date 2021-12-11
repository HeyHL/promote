package io.hel.controller;

import io.hel.anno.MethodAroundLogger;
import io.hel.vo.req.CreateReqVO;
import io.hel.vo.resp.DetailRespVO;
import io.hel.vo.resp.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helei
 * 2021/11/15 11:42
 * description:
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/mall/long")
@Api(tags = "MJ v2.2接口")
@Slf4j
@MethodAroundLogger
public class HelloController {

    @ApiOperation(value = "创建接龙")
    @PostMapping(value = "create")
    public ResultVO<DetailRespVO> create(@RequestBody CreateReqVO reqVO) {
        DetailRespVO res = new DetailRespVO();
        res.setTitle("resp title");
        return ResultVO.success(res);
    }
}
