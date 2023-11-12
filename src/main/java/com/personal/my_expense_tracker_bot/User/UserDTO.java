package com.personal.my_expense_tracker_bot.User;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {

    @Getter @Setter
    public Long id;

    @Getter @Setter
    public String userName;

    @Getter @Setter
    public String lastMonthExpenditure;

    public UserDTO(Long id, String userName, String lastMonthExpenditure){
        this.id = id;
        this.userName = userName;
        this.lastMonthExpenditure = lastMonthExpenditure;
    }
}
