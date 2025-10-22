package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Scanner;

@SpringBootApplication
public class ChatClientApplication implements CommandLineRunner {

    private WebSocketSession session;

    public static void main(String[] args) {
        SpringApplication.run(ChatClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        StandardWebSocketClient client = new StandardWebSocketClient();

        session = client
                .doHandshake(new ClientHandler(), "ws://localhost:8080/chat")
                .get();

        System.out.println("✅ Connected to server. Type messages below:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.nextLine();
            if ("exit".equalsIgnoreCase(msg)) break;
            session.sendMessage(new TextMessage(msg));
        }
        session.close();
        System.exit(0);
    }

    private class ClientHandler extends TextWebSocketHandler {
        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            System.out.println("Server: " + message.getPayload());
        }
    }
}
