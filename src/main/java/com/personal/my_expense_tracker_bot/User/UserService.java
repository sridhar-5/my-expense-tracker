package com.personal.my_expense_tracker_bot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<UserDTO> getAllUsers(){
        Iterable<User> users = userRepository.findAll();

        // Using StreamSupport to convert iterable to a stream
        return StreamSupport.stream(users.spliterator(), false)
                .map(user -> new UserDTO(user.getId(), user.getUserName(), user.getLastMonthExpenditure()))
                .collect(Collectors.toList());
    }
}
