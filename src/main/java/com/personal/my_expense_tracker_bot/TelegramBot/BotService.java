package com.personal.my_expense_tracker_bot.TelegramBot;

import com.personal.my_expense_tracker_bot.Expense.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class BotService {

    public ExpenseRepository expenseRepository;

    @Autowired
    public BotService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public SendMessage handleUpdate(Update update) {
        System.out.println(update);

        return SendMessage.builder()
                .chatId(update.getMessage().getChatId().toString()) //Who are we sending a message to
                .text("Hello World").build();
    }
}
