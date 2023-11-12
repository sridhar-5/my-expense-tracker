package com.personal.my_expense_tracker_bot.TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {

    private final BotService botService;

    public MyTelegramBot(BotService botService) {
        this.botService = botService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage responseMessage = botService.handleUpdate(update);
        try {
            execute(responseMessage);
        }catch(TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "sridhar_money_tracker_bot";
    }

    @Override
    public String getBotToken() {
        return "";
    }
}