package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.Set;

public class MessagesSeenRequest implements Serializable {

    @JsonbProperty("messagesUuids")
    private final Set<String> messagesUuids;

    public MessagesSeenRequest(final Set<String> messagesUuids) {
        this.messagesUuids = messagesUuids;
    }

    public Set<String> messagesUuids() {
        return this.messagesUuids;
    }

    @Override
    public String toString() {
        return "MessagesSeenRequest{" +
                "messagesUuids=" + messagesUuids +
                '}';
    }
}
