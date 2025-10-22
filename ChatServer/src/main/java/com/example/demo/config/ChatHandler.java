package com.example.demo.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {

	private WebSocketSession clientSession;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		this.clientSession = session;
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("Client : " + message.getPayload());
	}

	public void sendMessage(String message) throws IOException {
		if (clientSession != null && clientSession.isOpen()) {
			clientSession.sendMessage(new TextMessage(message));
		}
	}

}
