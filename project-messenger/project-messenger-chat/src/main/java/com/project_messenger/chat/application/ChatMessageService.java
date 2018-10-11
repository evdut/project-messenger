package com.project_messenger.chat.application;

import com.project_messenger.chat.domain.ChatMessage;
import com.project_messenger.chat.domain.ChatUser;
import com.project_messenger.chat.domain.repository.ChatMessageRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Inject
    public ChatMessageService(final ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessage add(final String chatUuid,
                           final ChatUser author,
                           final String body) {
        return chatMessageRepository.save(new ChatMessage(chatUuid, author, body));
    }

    public List<ChatMessage> messages(final String chatUuid) {
        return chatMessageRepository.messages(chatUuid);
    }
}
