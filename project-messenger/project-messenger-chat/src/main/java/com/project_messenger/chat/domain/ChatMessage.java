package com.project_messenger.chat.domain;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatMessage implements Serializable {

    private final String uuid;
    private final String chatUuid;
    private final ChatUser author;
    private final ZonedDateTime date;
    private final String body;

    public ChatMessage(final String chatUuid,
                       final ChatUser author,
                       final String body) {
        this.uuid = UUID.randomUUID().toString();
        this.chatUuid = chatUuid;
        this.author = author;
        this.date = ZonedDateTime.now(ZoneOffset.UTC);
        this.body = body;
    }

    public String uuid() {
        return this.uuid;
    }

    public String chatUuid() {
        return this.chatUuid;
    }

    public ChatUser author() {
        return this.author;
    }

    public ZonedDateTime date() {
        return this.date;
    }

    public String body() {
        return this.body;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "uuid='" + uuid + '\'' +
                ", chatUuid='" + chatUuid + '\'' +
                ", author=" + author +
                ", date=" + date +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(chatUuid, that.chatUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, chatUuid);
    }
}
