package io.hel.service.impl;

import cn.hutool.core.bean.BeanUtil;
import io.hel.bean.CHNRegion;
import io.hel.entity.Region;
import io.hel.mapper.CHNRegionMapper;
import io.hel.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * helei
 * 2021/11/25 14:13
 * description:
 */
@SuppressWarnings("all")
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private CHNRegionMapper chnRegionMapper;

    @Override
    public List<CHNRegion> getRegionTree() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
        List<Region> regionsFromDB = chnRegionMapper.selectRegion();

        List<CHNRegion> collect = regionsFromDB.stream().map(v -> {
            CHNRegion region = new CHNRegion();
            BeanUtil.copyProperties(v, region);
            return region;
        }).collect(Collectors.toList());
        Map<Integer, List<CHNRegion>> parent2regionMap =
                collect.stream().collect(Collectors.groupingBy(CHNRegion::getParentRegionId)).entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey
                        , value -> value.getValue().stream().sorted(Comparator.comparing(CHNRegion::getRegionId, Comparator.reverseOrder())).collect(Collectors.toList())));

        collect.forEach(i -> i.setSubRegion(parent2regionMap.get(i.getRegionId())));
        List<CHNRegion> res = collect.stream().filter(i -> i.getParentRegionId().equals(-1)).collect(Collectors.toList());
        return res;
    }

}
