package com.personal.my_expense_tracker_bot.Expense;

import com.personal.my_expense_tracker_bot.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    public Long id;

    @Getter @Setter
    public String expenseName;

    @Getter @Setter
    public LocalDateTime expenseCreatedAt;

    @Getter @Setter
    public double expenseAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Getter @Setter
    private String category;

    public Expense(String expenseName, double expenseAmount, LocalDateTime expenseCreatedAt, String category){
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.expenseCreatedAt = expenseCreatedAt;
        this.category = category;
    }

    public Expense() {};
}
