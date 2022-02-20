package com.capitalgain.unit.factory;

import com.capitalgain.factory.impl.CapitalGainFactoryImpl;
import com.capitalgain.model.Operation;
import com.capitalgain.strategy.CapitalGainStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CapitalGainFactoryTest {

    @InjectMocks
    private CapitalGainFactoryImpl factory;

    @Test
    void should_return_strategy() {
        CapitalGainStrategy strategy =
                factory.findStrategy(Operation.SELL);

        Assertions.assertNotNull(strategy);
    }

    @Test
    void should_not_return_strategy() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> factory.findStrategy(null));
    }

}
