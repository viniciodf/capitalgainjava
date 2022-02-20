package com.capitalgain.strategy;

import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.Context;
import com.capitalgain.model.Operation;

public interface CapitalGainStrategy {
    Double executeCapitalGain(Context context, CapitalGain currentCapitalGain);
    Operation getOperation();
}
