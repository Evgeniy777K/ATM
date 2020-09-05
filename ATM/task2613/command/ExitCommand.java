package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Sukora Stas.
 */
class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.exit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        try {
            if (ConsoleHelper.readString().equals("y")) {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//        System.out.println("Do you really want to exit? <y,n>");
//        String answer = ConsoleHelper.readString();
//        if (answer.equalsIgnoreCase("Y")) {
//            ConsoleHelper.writeMessage("Bye");
//        } else {
//            throw new InterruptOperationException();
//



