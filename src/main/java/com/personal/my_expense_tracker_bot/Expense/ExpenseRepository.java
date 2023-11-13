package com.personal.my_expense_tracker_bot.Expense;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAllByMonthAndYear(int month, int year); // TODO: THIS LOGIC IS NOT CORRECT REPLACE IT WITH SOMETHING ELSE
}
