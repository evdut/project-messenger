package com.project_messenger.chat.domain;

import java.io.Serializable;

public class Contacts implements Serializable {

    private String email;
    private String phone;

    public Contacts() {
    }

    public Contacts(final String email,
                    final String phone) {
        this.email = email;
        this.phone = phone;
    }

    public void updateEmail(final String email) {
        this.email = email;
    }

    public void updatePhone(final String phone) {
        this.phone = phone;
    }

    public String email() {
        return this.email;
    }

    public String phone() {
        return this.phone;
    }

    public Contacts update(final Contacts contacts) {
        if (contacts != null) {
            updateEmail(contacts.email());
            updatePhone(contacts.phone());
        }
        return this;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
