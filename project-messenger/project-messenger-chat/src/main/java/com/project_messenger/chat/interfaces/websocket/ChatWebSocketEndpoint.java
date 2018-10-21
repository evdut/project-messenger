package com.project_messenger.chat.interfaces.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/{uuid}")
public class ChatWebSocketEndpoint {

    @OnOpen
    public void connect(final Session session) {

    }

    @OnMessage
    public void receive(final Session session,
                        final String message) {

    }

    @OnClose
    public void close(final Session session,
                      final CloseReason reason) {

    }

    @OnError
    public void onError(final Session session,
                        final Throwable error) {

    }
}
