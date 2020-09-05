package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards", Locale.ENGLISH);
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.login_en",Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));
//   Пока пользователь не введет валидные номер карты и пин - выполнять следующие действия:
        while (true) {
//Запросить у пользователя 2 числа - номер кредитной карты
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String numberCard = ConsoleHelper.readString();
            String pinCod = ConsoleHelper.readString();
            if (validCreditCards.containsKey(numberCard)) {
//Вывести юзеру сообщение о невалидных данных, если они такими являются.
                if (validCreditCards.getString(numberCard).equals(pinCod))
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), numberCard));
                else {
// Если данные валидны, то проверить их на соответствие захардкоженным (123456789012 и 1234).
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), numberCard));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), numberCard));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            break;

        }
    }
}
