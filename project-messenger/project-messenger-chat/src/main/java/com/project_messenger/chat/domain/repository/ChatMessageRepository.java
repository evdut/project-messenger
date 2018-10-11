package com.project_messenger.chat.domain.repository;

import com.project_messenger.chat.domain.ChatMessage;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class ChatMessageRepository {

    private final List<ChatMessage> messages;

    public ChatMessageRepository() {
        this.messages = new ArrayList<>();
    }

    public ChatMessage save(final ChatMessage chatMessage) {
        messages.add(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> messages(final String chatUuid) {
        return messages.stream()
                .filter(chatMessage -> chatMessage.chatUuid().equals(chatUuid))
                .collect(Collectors.toList());
    }
}
