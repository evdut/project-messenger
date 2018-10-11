package com.project_messenger.chat;

import com.project_messenger.chat.application.ChatMessageService;
import com.project_messenger.chat.application.ChatService;
import com.project_messenger.chat.domain.Chat;
import com.project_messenger.chat.domain.ChatMessage;
import com.project_messenger.chat.domain.ChatUser;
import com.project_messenger.chat.domain.repository.ChatMessageRepository;
import com.project_messenger.chat.domain.repository.ChatRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class ChatTest {

    private ChatService chatService;
    private ChatMessageService chatMessageService;

    @Before
    public void init() {
        this.chatService = new ChatService(new ChatRepository());
        this.chatMessageService = new ChatMessageService(new ChatMessageRepository());
    }

    @Test
    public void startChatAndWriteMessagesTest() {
        //Given
        final String project = UUID.randomUUID().toString();

        final String chatUser1Uuid = UUID.randomUUID().toString();
        final String chatUser1Name = "User1";
        final ChatUser chatUser1 = new ChatUser(chatUser1Uuid, chatUser1Name);

        final String chatUser2Uuid = UUID.randomUUID().toString();
        final String chatUser2Name = "User2";
        final ChatUser chatUser2 = new ChatUser(chatUser2Uuid, chatUser2Name);

        //When start chat
        final Chat chat = chatService.startChat(project);

        //Then
        Assert.assertNotNull(chat);
        Assert.assertEquals(project, chat.project());

        //And When add new message
        chatMessageService.add(chat.uuid(), chatUser1, "Test message from " + chatUser1Name);
        chatMessageService.add(chat.uuid(), chatUser2, "Test message from " + chatUser2Name);

        //Then get 2 messages
        final List<ChatMessage> messages = chatMessageService.messages(chat.uuid());
        Assert.assertEquals(2, messages.size());
        Assert.assertTrue(messages.get(0).body().contains(chatUser1Name));
        Assert.assertTrue(messages.get(1).body().contains(chatUser2Name));
    }
}
