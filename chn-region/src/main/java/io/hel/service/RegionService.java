package io.hel.service;

import io.hel.bean.CHNRegion;

import java.util.List;

/**
 * helei
 * 2021/11/25 14:11
 * description:
 */
@SuppressWarnings("all")
public interface RegionService {
    List<CHNRegion> getRegionTree();
}
