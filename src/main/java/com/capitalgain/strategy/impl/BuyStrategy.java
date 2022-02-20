package com.capitalgain.strategy.impl;

import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.Context;
import com.capitalgain.model.Operation;
import com.capitalgain.strategy.CapitalGainStrategy;

public class BuyStrategy implements CapitalGainStrategy {

    @Override
    public Double executeCapitalGain(final Context context, final CapitalGain currentCapitalGain) {
        return 0d;
    }

    @Override
    public Operation getOperation() {
        return Operation.BUY;
    }
}
