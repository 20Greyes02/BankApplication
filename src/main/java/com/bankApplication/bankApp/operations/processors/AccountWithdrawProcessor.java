package com.bankApplication.bankApp.operations.processors;

import com.bankApplication.bankApp.account.AccountService;
import com.bankApplication.bankApp.operations.ConsoleOperationType;
import com.bankApplication.bankApp.operations.OperationCommandProcessor;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class AccountWithdrawProcessor implements OperationCommandProcessor {

    private final Scanner scanner;
    private final AccountService accountService;

    public AccountWithdrawProcessor(Scanner scanner, AccountService accountService) {
        this.scanner = scanner;
        this.accountService = accountService;
    }


    @Override
    public void processOperation() {
        System.out.println("Enter account id:");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter amount to deposit:");
        int amountToWithdraw = Integer.parseInt(scanner.nextLine());
        accountService.withdrawFromAccount(accountId, amountToWithdraw);
        System.out.println("Successfully withdraw amounnt %s to accountId %s"
                .formatted(amountToWithdraw,accountId));
    }

    @Override
    public ConsoleOperationType getOperationType() {
        return ConsoleOperationType.ACCOUNT_WITHDRAW;
    }
}
