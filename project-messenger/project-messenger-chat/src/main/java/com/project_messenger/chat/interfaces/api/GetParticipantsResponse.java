package com.project_messenger.chat.interfaces.api;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.List;

public class GetParticipantsResponse implements Serializable {

    @JsonbProperty("chatUuid")
    private final String chatUuid;

    @JsonbProperty("participants")
    private final List<Participant> participants;

    public GetParticipantsResponse(final String chatUuid,
                                   final List<Participant> participants) {
        this.chatUuid = chatUuid;
        this.participants = participants;
    }

    public String chatUuid() {
        return this.chatUuid;
    }

    public List<Participant> participants() {
        return this.participants;
    }

    @Override
    public String toString() {
        return "GetParticipantsResponse{" +
                "chatUuid='" + chatUuid + '\'' +
                ", participants=" + participants +
                '}';
    }
}
