package com.example.demo;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.config.ChatHandler;

@SpringBootApplication
public class ChatServerApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(ChatServerApplication.class, args);
		ChatHandler handler = context.getBean(ChatHandler.class); // get same instance managed by Spring

		Scanner scanner = new Scanner(System.in);
		System.out.println("💬 Type your message to client (type 'exit' to quit):");
		while (true) {
			String msg = scanner.nextLine();
			if ("exit".equalsIgnoreCase(msg))
				break;
			handler.sendMessage(msg);
		}
		System.exit(0);
	}

}
