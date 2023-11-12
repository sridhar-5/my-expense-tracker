package com.personal.my_expense_tracker_bot.Expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }
}
