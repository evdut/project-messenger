package com.project_messenger.chat.application;

import com.project_messenger.chat.domain.Chat;
import com.project_messenger.chat.domain.repository.ChatRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

@Stateless
public class ChatService {

    private final ChatRepository chatRepository;

    @Inject
    public ChatService(final ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat startChat(final String project) {
        return chatRepository.save(new Chat(project));
    }

    public Chat chat(final String project) {
        return chatRepository.chat(project).orElseThrow(EntityNotFoundException::new);
    }
}
