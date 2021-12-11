package io.hel.controller;

import io.hel.anno.MethodAroundLogger;
import io.hel.bean.CHNRegion;
import io.hel.service.RegionService;
import io.hel.vo.resp.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * helei
 * 2021/11/25 13:46
 * description:
 */
@SuppressWarnings("all")
@RestController
@RequestMapping(value = "sys")
@MethodAroundLogger
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping(value = "region")
    public ResultVO<List<CHNRegion>> getCHNRegion() throws Exception {
        List<CHNRegion> res = regionService.getRegionTree();
        return ResultVO.success(res);
    }
}
