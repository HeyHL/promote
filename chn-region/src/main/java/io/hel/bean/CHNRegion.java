package io.hel.bean;

import lombok.Data;

import java.util.List;

/**
 * helei
 * 2021/11/25 14:12
 * description:
 */
@SuppressWarnings("all")
@Data
public class CHNRegion {
    private Integer regionId;

    private String regionName;

    private String regionShortName;

    private String regionCode;

    private Integer parentRegionId;

    private List<CHNRegion> subRegion;
}
