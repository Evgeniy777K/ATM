package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) throws NotEnoughMoneyException {
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("usd");
        manipulator.addAmount(10, 1);
        manipulator.addAmount(100, 3);
        try {
            manipulator.withdrawAmount(205);
        } catch (NotEnoughMoneyException nem) {
            System.out.println("NotEnoughMoneyException");
        }

        Locale.setDefault(Locale.ENGLISH);

        try {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Bye!!!");
            ConsoleHelper.printExitMessage();

        }
    }
}

