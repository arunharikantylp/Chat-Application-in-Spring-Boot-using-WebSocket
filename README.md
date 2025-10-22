# WebSocket Chat Application (Spring Boot)

## Overview
This project demonstrates a real-time, two-way chat system using **Spring Boot WebSocket**.  
It includes two independent Spring Boot applications — a **Chat Server** and a **Chat Client** — that exchange messages through a WebSocket connection.

The goal is to simulate a **console-based chat system**, showcasing WebSocket fundamentals such as connection establishment, message handling, and full-duplex communication.

---

## Architecture

### Chat Server (App A)
- Hosts a WebSocket endpoint at `/chat`
- Uses Spring’s `TextWebSocketHandler` for message handling
- Reads console input and sends messages to connected clients

### Chat Client (App B)
- Connects to the server (`ws://localhost:8080/chat`) using `StandardWebSocketClient`
- Displays messages from the server
- Reads user input and sends messages back to the server

Both applications run independently on separate ports and maintain a persistent, bidirectional WebSocket connection.

---

## Features
- Full-duplex, real-time communication between server and client  
- WebSocket protocol over a single TCP connection  
- Simple Spring Boot integration with `WebSocketConfigurer` and `TextWebSocketHandler`  
- Console-based user interaction (no UI required)  
- Cross-origin support via `setAllowedOrigins("*")`  
- Singleton WebSocket handler bean for consistent session management  

---

## Tech Stack
- Java 17+
- Spring Boot 3+
- Spring WebSocket
- Maven
- JDK WebSocket API
- Console I/O (`Scanner`)

---

## How It Works
1. Start the **Chat Server** (default port 8080).  
2. Start the **Chat Client** (any available port, e.g., 8081).  
3. The client connects to the WebSocket endpoint at `ws://localhost:8080/chat`.  
4. Both server and client can type messages in the console and see responses instantly.

### Example Output
#### Server Side
- Hi
- Hello
- Client : Hello Client, How are you ?
- I am good, What about you ?
- Client : Nice to see you in command promt
- Developer made this possible
- Client : Ok good to hear
- Ok thank you bye!

#### Client Side
- Server: Hi
- Server: Hello
- Hello Client, How are you ?
- Server: I am good, What about you ?
- Nice to see you in command promt
- Server: Developer made this possible
- Ok good to hear
- Server: Ok thank you bye!


