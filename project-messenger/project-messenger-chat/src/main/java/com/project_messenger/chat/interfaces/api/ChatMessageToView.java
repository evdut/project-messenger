package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

public class ChatMessageToView implements Serializable {

    @JsonbProperty("chatUuid")
    private final String chatUuid;

    @JsonbProperty("uuid")
    private final String uuid;

    @JsonbProperty("author")
    private final Participant author;

    @JsonbProperty("mine")
    private final boolean mine;

    @JsonbProperty("body")
    private final String body;

    @JsonbProperty("files")
    private final Set<String> files;

    @JsonbProperty("date")
    private final ZonedDateTime date;

    public ChatMessageToView(final String chatUuid,
                             final String uuid,
                             final Participant author,
                             final boolean mine,
                             final String body,
                             final Set<String> files,
                             final ZonedDateTime date) {
        this.chatUuid = chatUuid;
        this.uuid = uuid;
        this.author = author;
        this.mine = mine;
        this.body = body;
        this.files = files;
        this.date = date;
    }

    public String chatUuid() {
        return this.chatUuid;
    }

    public String uuid() {
        return this.uuid;
    }

    public Participant author() {
        return this.author;
    }

    public boolean mine() {
        return this.mine;
    }

    public String body() {
        return this.body;
    }

    public Set<String> files() {
        return this.files;
    }

    public ZonedDateTime date() {
        return this.date;
    }

    @Override
    public String toString() {
        return "ChatMessageToView{" +
                "chatUuid='" + chatUuid + '\'' +
                ", uuid='" + uuid + '\'' +
                ", author=" + author +
                ", mine=" + mine +
                ", body='" + body + '\'' +
                ", files=" + files +
                ", date=" + date +
                '}';
    }
}
