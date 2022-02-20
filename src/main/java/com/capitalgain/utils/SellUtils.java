package com.capitalgain.utils;

import com.capitalgain.model.Context;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellUtils {

    public final Double TAX_PERCENT = 0.2;
    public final Double TAX_LIMIT = 20000d;
    public final Double BALANCE_ZERO = 0d;

    public boolean isLoss(final Double averageValue, final Double currentValue){
        return currentValue < averageValue;
    }

    public boolean isFreeOfTax(final Double unitCost, final Double quantity){
        return unitCost * quantity < TAX_LIMIT;
    }

    public Double getCurrentLossValue(final Context context, final Double quantity, final Double unitCost) {
        var baseValue = context.getAverageValue() * quantity;
        var currentValue = (quantity * unitCost);
        return baseValue < currentValue ? 0 : baseValue - currentValue;
    }

    public Double getCurrentProfitValue(final Context context, final Double quantity, final Double unitCost) {
        var baseValue = context.getAverageValue() * quantity;
        var currentValue = (quantity * unitCost);
        return baseValue > currentValue ? 0 : currentValue - baseValue;
    }

    public Double getCurrentProfitWithContextBalance(final Double balance, final Double currentProfitValue) {
        if(balance > BALANCE_ZERO){
            return balance < currentProfitValue ? currentProfitValue : currentProfitValue - balance;
        } else {
            return Math.abs(balance) > currentProfitValue ? 0 : currentProfitValue - Math.abs(balance);
        }
    }
}
