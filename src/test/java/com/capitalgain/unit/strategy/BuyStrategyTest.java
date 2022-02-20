package com.capitalgain.unit.strategy;

import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.Context;
import com.capitalgain.model.Operation;
import com.capitalgain.strategy.impl.BuyStrategy;
import com.capitalgain.unit.utils.MockDataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BuyStrategyTest {

    @InjectMocks
    private BuyStrategy buyStrategy;

    @Test
    void should_execute_capital_gain() {
        CapitalGain capitalGain = MockDataUtils.mockCapitalGain("buy", 10d, 10000d);
        Context context = MockDataUtils.mockContex(10d, 0d);
        Double tax = buyStrategy.executeCapitalGain(context, capitalGain);

        Assertions.assertNotNull(tax);
        Assertions.assertEquals(0d, tax);
    }

    @Test
    void should_return_operation_buy() {
        Operation operation = buyStrategy.getOperation();

        Assertions.assertNotNull(operation);
        Assertions.assertEquals(Operation.BUY, operation);
    }


}
