package com.capitalgain.unit.strategy;

import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.Context;
import com.capitalgain.model.Operation;
import com.capitalgain.strategy.impl.SellStrategy;
import com.capitalgain.unit.utils.MockDataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SellStrategyTest {

    @InjectMocks
    private SellStrategy sellStrategy;

    @Test
    void should_return_operation_sell() {
        Operation operation = sellStrategy.getOperation();

        Assertions.assertNotNull(operation);
        Assertions.assertEquals(Operation.SELL, operation);
    }

    @Test
    void should_tax_operation_when_profit_greater_then_tax_limit() {
        CapitalGain capitalGain = MockDataUtils.mockCapitalGain("sell", 20d, 5000d);
        Context context = MockDataUtils.mockContex(10d, 0d);
        Double tax = sellStrategy.executeCapitalGain(context, capitalGain);

        Assertions.assertNotNull(tax);
        Assertions.assertEquals(10000d, tax);
    }

    @Test
    void should_tax_operation_when_profit_greater_then_tax_limit_and_balance_less_then_zero() {
        CapitalGain capitalGain = MockDataUtils.mockCapitalGain("sell", 20d, 5000d);
        Context context = MockDataUtils.mockContex(10d, -1000d);
        Double tax = sellStrategy.executeCapitalGain(context, capitalGain);

        Assertions.assertNotNull(tax);
        Assertions.assertEquals(9800d, tax);
    }

    @Test
    void should_tax_operation_when_profit_greater_then_tax_limit_and_balance_greater_then_zero() {
        CapitalGain capitalGain = MockDataUtils.mockCapitalGain("sell", 20d, 5000d);
        Context context = MockDataUtils.mockContex(10d, 1000d);
        Double tax = sellStrategy.executeCapitalGain(context, capitalGain);

        Assertions.assertNotNull(tax);
        Assertions.assertEquals(10000d, tax);
    }

    @Test
    void should_not_tax_operation_when_profit_greater_then_tax_limit_and_balance_greater_then_zero_and_greater_then_profit() {
        CapitalGain capitalGain = MockDataUtils.mockCapitalGain("sell", 20d, 5000d);
        Context context = MockDataUtils.mockContex(10d, 50000d);
        Double tax = sellStrategy.executeCapitalGain(context, capitalGain);

        Assertions.assertNotNull(tax);
        Assertions.assertEquals(0d, tax);
    }


    @Test
    void should_not_tax_operation_when_profit_less_then_tax_limit() {
        CapitalGain capitalGain = MockDataUtils.mockCapitalGain("sell", 15d, 50d);
        Context context = MockDataUtils.mockContex(10d, 0d);
        Double tax = sellStrategy.executeCapitalGain(context, capitalGain);

        Assertions.assertNotNull(tax);
        Assertions.assertEquals(0d, tax);
    }

}
