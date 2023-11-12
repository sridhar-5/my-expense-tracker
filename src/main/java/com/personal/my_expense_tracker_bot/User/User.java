package com.personal.my_expense_tracker_bot.User;

import com.personal.my_expense_tracker_bot.Expense.Expense;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String userName;

    @Getter @Setter
    private String lastMonthExpenditure;

    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;
}
