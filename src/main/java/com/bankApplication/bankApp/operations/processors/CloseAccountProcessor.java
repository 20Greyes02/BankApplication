package com.bankApplication.bankApp.operations.processors;

import com.bankApplication.bankApp.account.Account;
import com.bankApplication.bankApp.account.AccountService;
import com.bankApplication.bankApp.operations.ConsoleOperationType;
import com.bankApplication.bankApp.operations.OperationCommandProcessor;
import com.bankApplication.bankApp.user.User;
import com.bankApplication.bankApp.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class CloseAccountProcessor implements OperationCommandProcessor {
    private final Scanner scanner;
    private final AccountService accountService;

    private final UserService userService;

    public CloseAccountProcessor(Scanner scanner, UserService userService, AccountService accountService) {
        this.scanner = scanner;
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void processOperation() {
        System.out.println("Enter account to close");
        int accountId = Integer.parseInt(scanner.nextLine());
        Account account = accountService.closeAccount(accountId);
        User user = userService.findUserById(account.getUserId()).orElseThrow(() -> new IllegalArgumentException("No such user with id: %s"
                .formatted(account.getUserId())));
        user.getAccountList().remove(account);

        System.out.println("Account successfully closed with id: %s".formatted(accountId));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_CLOSE;
    }
}
