package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en", Locale.ENGLISH);

    //  который будет писать в консоль наше сообщение
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    //который будет считывать с консоли строку и возвращать ее
    public static String readString() throws InterruptOperationException {
        String message = null;
        try {
            message = bis.readLine();
        } catch (Exception e) {
        }
        if (message != null) {
            if (res.getString("operation.EXIT").equalsIgnoreCase(message)) {
                throw new InterruptOperationException();
            }
        }
        return message;

    }

    //считаem код валюты
    public static String askCurrencyCode() throws InterruptOperationException {
        String code = "";
        writeMessage(res.getString("choose.currency.code"));
        while (true) {
            code = readString();
            if (code.length() == 3)
                break;
            else
                writeMessage(res.getString("invalid.data"));
        }
        return code.toUpperCase();
    }

    //    считать номинал и количество банкнот
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String[] cash;
        while (true) {
            try {
                cash = readString().split(" ");

                if (Integer.parseInt(cash[0]) > 0 && Integer.parseInt(cash[1]) > 0 && cash.length == 2)
                    break;
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }

            writeMessage(res.getString("invalid.data"));
        }
        return cash;
    }

    //    Спросить у пользователя операцию.
    public static Operation askOperation() throws InterruptOperationException {
        boolean isOperation = false;
        while (!isOperation) {
            try {
                //writeMessage("Enter number of operation (1 - INFO, 2 — DEPOSIT, 3 — WITHDRAW, 4 — EXIT):");
                writeMessage(res.getString("choose.operation") +
                        " (1 - " + res.getString("operation.INFO") +
                        ", 2 — " + res.getString("operation.DEPOSIT") +
                        ", 3 — " + res.getString("operation.WITHDRAW") +
                        ", 4 — " + res.getString("operation.EXIT") + "):");
                int numberOfOperation = Integer.parseInt(readString());
                Operation operation = Operation.getAllowableOperationByOrdinal(numberOfOperation);
                return operation;
            } catch (IllegalArgumentException e) {
            }
        }
        return null;
    }
    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}