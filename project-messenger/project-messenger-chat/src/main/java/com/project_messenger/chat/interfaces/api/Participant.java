package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

public class Participant implements Serializable {

    @JsonbProperty("uuid")
    private final String uuid;

    @JsonbProperty("name")
    private final String name;

    public Participant(final String uuid,
                       final String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String uuid() {
        return this.uuid;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return "ChatUser{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
