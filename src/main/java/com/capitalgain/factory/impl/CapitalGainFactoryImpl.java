package com.capitalgain.factory.impl;

import com.capitalgain.factory.CapitalGainFactory;
import com.capitalgain.model.Operation;
import com.capitalgain.strategy.CapitalGainStrategy;
import com.capitalgain.strategy.impl.BuyStrategy;
import com.capitalgain.strategy.impl.SellStrategy;

public class CapitalGainFactoryImpl implements CapitalGainFactory {

    @Override
    public CapitalGainStrategy findStrategy(final Operation operation) {
        if (Operation.BUY.equals(operation)) {
            return new BuyStrategy();
        } else if (Operation.SELL.equals(operation)) {
            return new SellStrategy();
        }
        throw new RuntimeException("Strategy not loaded");
    }
}
