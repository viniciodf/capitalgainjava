package com.capitalgain.service.impl;

import com.capitalgain.factory.CapitalGainFactory;
import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.Context;
import com.capitalgain.model.Operation;
import com.capitalgain.model.CapitalGainTax;
import com.capitalgain.service.CapitalGainService;
import com.capitalgain.strategy.CapitalGainStrategy;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CapitalGainServiceImpl implements CapitalGainService {

    private final CapitalGainFactory capitalGainFactory;

    @Override
    public List<CapitalGainTax> calculateTax(final List<CapitalGain> capitalGains) {
        Context context = loadContext(capitalGains);
        return processTaxes(capitalGains, context);
    }

    private List<CapitalGainTax> processTaxes(final List<CapitalGain> capitalGains, final Context context) {
        return capitalGains.stream().map(capitalGain -> processTax(context, capitalGain)).collect(Collectors.toCollection(LinkedList::new));
    }

    private CapitalGainTax processTax(final Context context, final CapitalGain capitalGain) {
        Double tax = executeCapitalGain(context, capitalGain);
        return CapitalGainTax.builder().tax(tax.intValue()).build();
    }

    private List<CapitalGain> getOnlyBuyOperations(List<CapitalGain> capitalGains) {
        return capitalGains.stream().filter(capitalGain -> Operation.BUY.equals(Operation.valueOf(capitalGain.getOperation().toUpperCase()))).collect(Collectors.toList());
    }

    private Double executeCapitalGain(final Context context, final CapitalGain currentCapitalGain) {
        CapitalGainStrategy strategy = capitalGainFactory.findStrategy(Operation.valueOf(currentCapitalGain.getOperation().toUpperCase()));
        return strategy.executeCapitalGain(context, currentCapitalGain);
    }

    private Context loadContext(final List<CapitalGain> capitalGainsBuy) {
        var averageValue = getAverageValue(capitalGainsBuy);
        return Context.builder().averageValue(averageValue).build();
    }

    private Double getAverageValue(List<CapitalGain> capitalGainsBuy) {
        var onlyBuyOperations = getOnlyBuyOperations(capitalGainsBuy);
        var totalQuantity = getTotalQuantity(onlyBuyOperations);
        return onlyBuyOperations.stream().reduce(0d, (partialSum, b) -> partialSum + (b.getQuantity() * b.getUnitCost()), Double::sum) / totalQuantity;
    }

    private Double getTotalQuantity(List<CapitalGain> capitalGainsBuy) {
        return capitalGainsBuy.stream().reduce(0d, (partialTotal, item) -> partialTotal + item.getQuantity(), Double::sum);
    }
}
