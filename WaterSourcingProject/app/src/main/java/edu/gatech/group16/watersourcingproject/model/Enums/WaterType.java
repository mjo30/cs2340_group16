package edu.gatech.group16.watersourcingproject.model.Enums;

import java.io.Serializable;

/**
 * Created by Edwin Zhao on 2017/02/23.
 * Bottled, Well, Stream, Lake, Spring, Other
 */

public enum WaterType implements Serializable {
    BOTTLED("Bottled"),
    WELL("Well"),
    STREAM("Stream"),
    LAKE("Lake"),
    SPRING("Spring"),
    OTHER("Other");

    private String waterType;

    WaterType(String accountType) {
        this.waterType = accountType;
    }
    public String getWaterType() {
        return waterType;
    }
}
