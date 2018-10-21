package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

public class WritingMessageRequest implements Serializable {

    @JsonbProperty("chatUuid")
    private final String chatUuid;

    @JsonbProperty("userUuid")
    private final String userUuid;

    public WritingMessageRequest(final String chatUuid,
                                 final String userUuid) {
        this.chatUuid = chatUuid;
        this.userUuid = userUuid;
    }

    public String chatUuid() {
        return this.chatUuid;
    }

    public String userUuid() {
        return this.userUuid;
    }

    @Override
    public String toString() {
        return "WritingMessageRequest{" +
                "chatUuid='" + chatUuid + '\'' +
                ", userUuid='" + userUuid + '\'' +
                '}';
    }
}
