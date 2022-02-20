package com.capitalgain.integration;

import com.capitalgain.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CapitalGainIntegrationTest {

    @Test
    public void should_calculate_tax() {
        String userInput = "[{\"operation\":\"buy\", \"unit-cost\":10, \"quantity\": 10000},{\"operation\":\"sell\",\"unit-cost\":2, \"quantity\":5000},{\"operation\":\"sell\", \"unit-cost\":20, \"quantity\":2000},{\"operation\":\"sell\", \"unit-cost\":20, \"quantity\":2000},{\"operation\":\"sell\",\"unit-cost\":25, \"quantity\": 1000}]";
        String expected = "[{\"tax\":0},{\"tax\":0},{\"tax\":0},{\"tax\":0},{\"tax\":3000}]";

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(new String[]{});

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length - 1];

        Assertions.assertEquals(expected, actual);

    }
}
