package com.bankApplication.bankApp.operations.processors;

import com.bankApplication.bankApp.operations.ConsoleOperationType;
import com.bankApplication.bankApp.operations.OperationCommandProcessor;
import com.bankApplication.bankApp.user.User;
import com.bankApplication.bankApp.user.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ShowAllUserProcessor implements OperationCommandProcessor {
    private final UserService userService;
    public ShowAllUserProcessor(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void processOperation() {
        List<User> users = userService.getAllUsers();
        System.out.println("List of users:");
        users.forEach(System.out::println);
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.SHOW_ALL_USERS;
    }
}
