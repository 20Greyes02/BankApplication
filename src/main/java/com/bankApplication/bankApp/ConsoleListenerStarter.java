package com.bankApplication.bankApp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ConsoleListenerStarter {
    private final OperationConsoleListener consoleListener;

    private Thread consoleListenerTread;

    public ConsoleListenerStarter(OperationConsoleListener consoleListener) {
        this.consoleListener = consoleListener;
    }

    @PostConstruct
    public void postConsctruct(){
        this.consoleListenerTread = new Thread(() -> {
            consoleListener.start();
            consoleListener.listenUpdates();
        });
        consoleListenerTread.start();
    }

    @PreDestroy
    public void preDestroy(){
        consoleListenerTread.interrupt();
        consoleListener.endListen();
    }
}
