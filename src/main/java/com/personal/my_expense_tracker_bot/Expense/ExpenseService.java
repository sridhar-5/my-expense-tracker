package com.personal.my_expense_tracker_bot.Expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ArrayList<Expense> createExpenseReport(String month, String year){
        return new ArrayList<>(expenseRepository.findAllByMonthAndYear(getMonth(month), getYear(year)));
    }


    public static int getYear(String year){
        return Integer.parseInt("20"+year);
    }
    public static int getMonth(String month){
        Map<String, Integer> months = createMonthCodeMap();
        return months.get(month);
    }

    public static Map<String, Integer> createMonthCodeMap() {
        Map<String, Integer> monthCodeMap = new HashMap<>();

        monthCodeMap.put("jan", 1);
        monthCodeMap.put("feb", 2);
        monthCodeMap.put("mar", 3);
        monthCodeMap.put("apr", 4);
        monthCodeMap.put("may", 5);
        monthCodeMap.put("jun", 6);
        monthCodeMap.put("jul", 7);
        monthCodeMap.put("aug", 8);
        monthCodeMap.put("sep", 9);
        monthCodeMap.put("oct", 10);
        monthCodeMap.put("nov", 11);
        monthCodeMap.put("dec", 12);

        return monthCodeMap;
    }
}
