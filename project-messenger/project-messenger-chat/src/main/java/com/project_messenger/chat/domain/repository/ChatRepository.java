package com.project_messenger.chat.domain.repository;

import com.project_messenger.chat.domain.Chat;

import javax.ejb.Stateful;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Stateful
public class ChatRepository {

    private final Map<String, Chat> chats;

    public ChatRepository() {
        this.chats = new ConcurrentHashMap<>();
    }

    public Chat save(final Chat chat) {
        chats.putIfAbsent(chat.project(), chat);
        return chat;
    }

    public Optional<Chat> chat(final String project) {
        return Optional.ofNullable(chats.get(project));
    }
}
