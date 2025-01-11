package com.bankApplication.bankApp.operations.processors;

import com.bankApplication.bankApp.account.AccountService;
import com.bankApplication.bankApp.operations.ConsoleOperationType;
import com.bankApplication.bankApp.operations.OperationCommandProcessor;
import com.bankApplication.bankApp.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class CreateAccountProcessor implements OperationCommandProcessor {

    public CreateAccountProcessor(Scanner scanner, UserService userService, AccountService accountService) {
        this.scanner = scanner;
        this.userService = userService;
        this.accountService = accountService;
    }

    private final Scanner scanner;
    private final UserService userService;
    private final AccountService accountService;


    @Override
    public void processOperation() {
        System.out.println("Enter the user id for which to create an account");
        int userId = Integer.parseInt(scanner.nextLine());
        var user = userService.findUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No such user with id=%s".formatted(userId)));
        var account = accountService.createAccount(user);
        user.getAccountList().add(account);

        System.out.println("New account created with id: %s for user: %s"
                .formatted(account.getId(), user.getLogin()));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_CREATE;
    }
}
