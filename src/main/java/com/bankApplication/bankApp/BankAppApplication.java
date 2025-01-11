package com.bankApplication.bankApp;

import com.bankApplication.bankApp.operations.ConsoleOperationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BankAppApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext("com.bankApplication.bankApp");
	}
}
