package com.capitalgain.unit.service;

import com.capitalgain.factory.CapitalGainFactory;
import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.CapitalGainTax;
import com.capitalgain.model.Operation;
import com.capitalgain.service.impl.CapitalGainServiceImpl;
import com.capitalgain.strategy.CapitalGainStrategy;
import com.capitalgain.unit.utils.MockDataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CapitalGainServiceTest {

    @InjectMocks
    private CapitalGainServiceImpl service;
    @Mock
    private CapitalGainFactory capitalGainFactory;
    @Mock
    private CapitalGainStrategy capitalGainStrategy;

    @Test
    void should_calculate_tax() {
        List<CapitalGain> capitalGains = MockDataUtils.mockListCapitalGain();

        when(capitalGainFactory.findStrategy(Operation.SELL)).thenReturn(capitalGainStrategy);
        when(capitalGainFactory.findStrategy(Operation.BUY)).thenReturn(capitalGainStrategy);
        when(capitalGainStrategy.executeCapitalGain(any(), any())).thenReturn(0d);

        List<CapitalGainTax> taxes =
                service.calculateTax(capitalGains);

        Assertions.assertNotNull(taxes);
        Assertions.assertEquals(capitalGains.size(), taxes.size());

    }

}
