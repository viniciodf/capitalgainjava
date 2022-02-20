package com.capitalgain.service;

import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.CapitalGainTax;

import java.util.List;

public interface CapitalGainService {
    List<CapitalGainTax> calculateTax(List<CapitalGain> capitalGain);
}
