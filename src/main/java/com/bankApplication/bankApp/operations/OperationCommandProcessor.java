package com.bankApplication.bankApp.operations;

public interface OperationCommandProcessor {
    void processOperation();
    ConsoleOperationType getOperationType();
}
