package com.capitalgain.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CapitalGain {
    private String operation;
    private Double quantity;
    @SerializedName("unit-cost")
    private Double unitCost;
}
