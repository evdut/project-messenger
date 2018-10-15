package com.project_messenger.project.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.javamoney.moneta.Money;

public class Task implements Serializable {

    private String uuid;
    
    @NotNull
    private String title;

    private String description;
    
    private Status status;
    
    private LocalDate dueDate;
    
    private Money costs;
    
    private User owner;
    
    private List<User> participants;
    
    private List<User> invited;
    
    public Task(String title, String description, User owner) {
        this.uuid = UUID.randomUUID().toString();
        update(title, description);
        this.owner = owner;
        this.invited = new ArrayList<User>();
        this.participants = new ArrayList<User>();
        this.status = Status.CREATED;
    }

    public void start() {
        this.status = Status.IN_PROGRESS;
    }
    
    public void finish() {
        this.status = Status.DONE;
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void schedule(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void addCosts(Money costs) {
        this.costs = costs;
    }
    
    public void invite(User invited) {
        this.invited.add(invited);
    }

    public void confirmInvitation(User user) {
        this.invited.remove(user);
        this.participants.add(user);
    }
    
    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String uuid() {
        return uuid;
    }
    
    public LocalDate dueDate() {
        return dueDate;
    }

    public Money costs() {
        return costs;
    }

    public User owner() {
        return owner;
    }

    public List<User> participants() {
        return participants;
    }

    public List<User> invitedUsers() {
        return invited;
    }

    public Status status() {
        return status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }
  
}
