package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

//который будет хранить всю информацию про выбранную валюту.
public class CurrencyManipulator {
    public boolean hasMoney() {
        return denominations.size() != 0;
    }

    //код валюты, например, USD. Состоит из трех букв.
    private String currencyCode;
    //это Map<номинал, количество>.
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    //который добавит введенные номинал и количество банкнот
    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    //Возвращает общее кол-во денег в одной валюте
    public int getTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> map : denominations.entrySet()) {
            totalAmount += map.getKey() * map.getValue();
        }
        return totalAmount;
    }

    //который вернет true, если денег достаточно для выдачи
    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();


    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
//   Копируем существующую карту во временную
        temp.putAll(denominations);
        ArrayList<Integer> nominals = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            nominals.add(pair.getKey());
        Collections.sort(nominals);
        Collections.reverse(nominals);
        TreeMap<Integer, Integer> result = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                });
        for (Integer nominal : nominals) {
            int key = nominal;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }
        if (sum > 0)
            throw new NotEnoughMoneyException();
        else {
            denominations.clear();
            denominations.putAll(temp);
        }
        return result;
    }

}


