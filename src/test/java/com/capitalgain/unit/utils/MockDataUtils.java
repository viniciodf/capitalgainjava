package com.capitalgain.unit.utils;

import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.Context;

import java.util.List;

public class MockDataUtils {
    public static List<CapitalGain> mockListCapitalGain() {
        CapitalGain mock1 = mockCapitalGain("buy", 10d, 10000d);
        CapitalGain mock2 = mockCapitalGain("sell", 2d, 5000d);
        CapitalGain mock3 = mockCapitalGain("sell", 20d, 2000d);
        CapitalGain mock4 = mockCapitalGain("sell", 20d, 2000d);
        CapitalGain mock5 = mockCapitalGain("sell", 25d, 1000d);
        return List.of(mock1, mock2, mock3, mock4, mock5);
    }

    public static CapitalGain mockCapitalGain(String operation, Double unitCost, Double quantity) {
        return CapitalGain.builder().operation(operation).unitCost(unitCost).quantity(quantity).build();
    }

    public static Context mockContex(Double averageValue, Double balance) {
        return Context.builder().averageValue(averageValue).balance(balance).build();
    }
}
