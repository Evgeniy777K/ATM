package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//
public class CurrencyManipulatorFactory {
//    который вернет Collection всех манипуляторов
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    //В этом методе будем создавать нужный манипулятор
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (!map.containsKey(currencyCode.toUpperCase()))
            map.put(currencyCode.toUpperCase(), new CurrencyManipulator(currencyCode));

        return map.get(currencyCode.toUpperCase());
    }
}
