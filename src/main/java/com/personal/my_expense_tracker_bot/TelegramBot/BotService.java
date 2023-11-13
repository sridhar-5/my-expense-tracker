package com.personal.my_expense_tracker_bot.TelegramBot;

import com.personal.my_expense_tracker_bot.Expense.Expense;
import com.personal.my_expense_tracker_bot.Expense.ExpenseService;
import com.personal.my_expense_tracker_bot.User.User;
import com.personal.my_expense_tracker_bot.User.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BotService {

    public ExpenseService expenseService;
    public UserService userService;
    Logger logger = LoggerFactory.getLogger(BotService.class);

    @Autowired
    public BotService(ExpenseService expenseService, UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    public SendMessage handleUpdate(Update update) {
        logger.info("User Id: " + update.getMessage().getFrom().getUserName() + "Message Sent: " + update.getMessage().getText());
        String sentMessage = update.getMessage().getText();

        if (sentMessage.matches("^(\\d+)-([a-zA-Z]+)-([a-zA-Z]+)$")) {
            logger.info("passed here");
            //something here
            String[] details = sentMessage.split("-");
            if(details.length != 3){
                return sendText(
                        update.getMessage().getChatId().toString(),
                        "Please gimme a valid String"
                );
            } else {
                Expense expense = expenseService.createExpense(new Expense(details[1], Double.parseDouble(details[0]), LocalDateTime.now(), details[2]));
                logger.info("ExpenseName:" + expense.expenseName + "ExpenseAmount: " + expense.expenseAmount + "ExpenseDate: " + expense.expenseCreatedAt);
                return sendText(
                        update.getMessage().getChatId().toString(),
                        "Expense Recorded..! Thank You"
                );
            }
        } else if (sentMessage.equals("/create-user")){
            userService.createUser(new User(update.getMessage().getFrom().getId() ,update.getMessage().getFrom().getUserName()));
            return sendText(update.getMessage().getChatId().toString(), "User Record Created...!");
        } else if (sentMessage.matches("^/get-expense-report\\s([a-zA-Z]+)-([0-9]{2})$")){
            String[] monthYear = sentMessage.split(" ")[1].split("-");
            List<Expense> expenseReport = expenseService.createExpenseReport(monthYear[0], monthYear[1]);
        }
        return sendText(update.getMessage().getChatId().toString(), "The given input is not matching any of the allowed commands. please try again.");
    }

    public SendMessage sendText(String chatId, String message){
        return SendMessage.builder()
                .chatId(chatId)
                .text(message).build();
    }
}
