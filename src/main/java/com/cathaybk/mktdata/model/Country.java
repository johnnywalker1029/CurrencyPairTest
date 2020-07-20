package com.cathaybk.mktdata.model;

public enum Country {
    FR("FRANCE"),
    HK("HONG KONG"),
    CHINA("CHINA"),
    IRELAND("IRELAND"),
    ICELAND("ICELAND");

    private String description;

    Country(String description) {
        this.description = description;
    }
}
