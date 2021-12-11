package io.hel.entity;

import lombok.Data;

/**
 * helei
 * 2021/11/25 13:46
 * description:
 */
@SuppressWarnings("all")
@Data
public class Region {
    private Integer regionId;

    private String regionName;

    private String regionShortName;

    private Integer regionCode;

    private Integer parentRegionId;

    private Integer regionLevel;
}
