package com.capitalgain.strategy.impl;

import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.Context;
import com.capitalgain.model.Operation;
import com.capitalgain.strategy.CapitalGainStrategy;
import com.capitalgain.utils.SellUtils;

public class SellStrategy implements CapitalGainStrategy {

    @Override
    public Double executeCapitalGain(final Context context, final CapitalGain currentCapitalGain) {
        var tax = 0d;
        var isLoss = SellUtils.isLoss(context.getAverageValue(), currentCapitalGain.getUnitCost());
        var ifFreeOfTax = SellUtils.isFreeOfTax(currentCapitalGain.getUnitCost(), currentCapitalGain.getQuantity());
        var currentLossValue = SellUtils.getCurrentLossValue(context, currentCapitalGain.getQuantity(), currentCapitalGain.getUnitCost());
        var currentProfitValue = SellUtils.getCurrentProfitValue(context, currentCapitalGain.getQuantity(), currentCapitalGain.getUnitCost());

        if(!isLoss && !ifFreeOfTax){
            var currentProfit = SellUtils.getCurrentProfitWithContextBalance(context.getBalance(), currentProfitValue);
            tax = calculateTax(currentProfit);
        }

        updateBalance(context, isLoss, currentLossValue, currentProfitValue);

        return tax;
    }

    private void updateBalance(Context context, boolean isLoss, Double currentLossValue, Double currentProfitValue) {
        if(isLoss){
            context.setBalance(context.getBalance() - currentLossValue);
        } else {
            context.setBalance(context.getBalance() + currentProfitValue);
        }
    }

    private Double calculateTax(Double value){
        return value * SellUtils.TAX_PERCENT;
    }

    @Override
    public Operation getOperation() {
        return Operation.SELL;
    }
}
