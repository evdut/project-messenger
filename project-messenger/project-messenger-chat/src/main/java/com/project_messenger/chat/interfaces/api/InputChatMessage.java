package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.Set;

public class InputChatMessage implements Serializable {

    @JsonbProperty("chatUuid")
    private final String chatUuid;

    @JsonbProperty("body")
    private final String body;

    @JsonbProperty("files")
    private final Set<String> files;

    public InputChatMessage(final String chatUuid,
                            final String body,
                            final Set<String> files) {
        this.chatUuid = chatUuid;
        this.body = body;
        this.files = files;
    }

    public String chatUuid() {
        return this.chatUuid;
    }

    public String body() {
        return this.body;
    }

    public Set<String> files() {
        return this.files;
    }

    @Override
    public String toString() {
        return "InputChatMessage{" +
                "chatUuid='" + chatUuid + '\'' +
                ", body='" + body + '\'' +
                ", files=" + files +
                '}';
    }
}
