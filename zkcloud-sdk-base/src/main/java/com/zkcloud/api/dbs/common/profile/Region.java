package com.zkcloud.api.dbs.common.profile;

public enum Region {
    Guangzhou("gz");

    private final String region;

    Region(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return this.region;
    }

    public String getValue() {
        return this.region;
    }
}
