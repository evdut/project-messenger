package com.project_messenger.chat.domain;

import java.io.Serializable;
import java.util.Objects;

public class ChatUser implements Serializable {

    private final String uuid;
    private String name;
    private final Contacts contacts;

    public ChatUser(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.contacts = new Contacts();
    }

    public ChatUser(final String uuid,
                    final String name,
                    final Contacts contacts) {
        this(uuid, name);
        this.contacts.update(contacts);
    }

    public void updateName(final String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String uuid() {
        return this.uuid;
    }

    public String name() {
        return this.name;
    }

    public String email() {
        return contacts.email();
    }

    public String phone() {
        return contacts.phone();
    }

    @Override
    public String toString() {
        return "ChatUser{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatUser chatUser = (ChatUser) o;
        return Objects.equals(uuid, chatUser.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
