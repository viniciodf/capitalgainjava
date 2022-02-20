package com.capitalgain;

import com.capitalgain.factory.impl.CapitalGainFactoryImpl;
import com.capitalgain.model.CapitalGain;
import com.capitalgain.model.CapitalGainTax;
import com.capitalgain.service.impl.CapitalGainServiceImpl;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<CapitalGain> capitalGains = readInput();
        CapitalGainServiceImpl capitalGainService = new CapitalGainServiceImpl(new CapitalGainFactoryImpl());
        List<CapitalGainTax> taxes = capitalGainService.calculateTax(capitalGains);
        writeOutput(taxes);
    }

    private static void writeOutput(List<CapitalGainTax> taxes) {
        System.out.println(new Gson().toJson(taxes));
    }

    private static List<CapitalGain> readInput() {
        Scanner scanner = new Scanner(System.in);
        String jsonString = scanner.nextLine();
        return new LinkedList<>(Arrays.asList(new Gson().fromJson(jsonString, CapitalGain[].class)));
    }
}
