package com.bankApplication.bankApp.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountProperties {
    private final int defaultAccountAmount;

    private final double transferComission;
    public AccountProperties(@Value("${account.default-amount}") int defaultAccountAmount,
                             @Value("${account.transfer-commission}") double transferComission) {
        this.defaultAccountAmount = defaultAccountAmount;
        this.transferComission = transferComission;
    }
    public int getDefaultAccountAmount() {
        return defaultAccountAmount;
    }

    public double getTransferComission() {
        return transferComission;
    }

}
