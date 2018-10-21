package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

public class OnlineStatusResponse implements Serializable {

    @JsonbProperty("online")
    private final boolean online;

    @JsonbProperty("userUuid")
    private final String userUuid;

    public OnlineStatusResponse(final boolean online,
                                final String userUuid) {
        this.online = online;
        this.userUuid = userUuid;
    }

    public boolean online() {
        return this.online;
    }

    public String userUuid() {
        return this.userUuid;
    }

    @Override
    public String toString() {
        return "OnlineStatusResponse{" +
                "online=" + online +
                ", userUuid='" + userUuid + '\'' +
                '}';
    }
}
