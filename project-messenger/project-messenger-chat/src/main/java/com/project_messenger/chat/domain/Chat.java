package com.project_messenger.chat.domain;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Chat implements Serializable {

    private final String project;
    private final String uuid;
    private final List<ChatUser> participants;
    private final ZonedDateTime startDate;

    public Chat(final String project) {
        this.project = project;
        this.uuid = UUID.randomUUID().toString();
        this.participants = new ArrayList<>();
        this.startDate = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public boolean participate(final ChatUser participant) {
        return participants.add(participant);
    }

    public boolean finishParticipate(final ChatUser chatUser) {
        return participants.remove(chatUser);
    }

    public String project() {
        return this.project;
    }

    public String uuid() {
        return this.uuid;
    }

    public List<ChatUser> participants() {
        return Collections.unmodifiableList(this.participants);
    }

    public ZonedDateTime startDate() {
        return this.startDate;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "project='" + project + '\'' +
                ", uuid='" + uuid + '\'' +
                ", participants=" + participants +
                ", startDate=" + startDate +
                '}';
    }
}
