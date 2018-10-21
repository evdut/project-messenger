package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

public class WritingMessageResponse implements Serializable {

    @JsonbProperty("chatUuid")
    private final String chatUuid;

    @JsonbProperty("username")
    private final String username;

    public WritingMessageResponse(final String chatUuid,
                                  final String username) {
        this.chatUuid = chatUuid;
        this.username = username;
    }

    public String chatUuid() {
        return this.chatUuid;
    }

    public String username() {
        return this.username;
    }

    @Override
    public String toString() {
        return "WritingMessageResponse{" +
                "chatUuid='" + chatUuid + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
