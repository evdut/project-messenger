package com.project_messenger.project.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.javamoney.moneta.Money;

public class Task implements Serializable {

    // @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "ProjectSeqGenerator")
    // @SequenceGenerator(name = "ProjectSeqGenerator", sequenceName =
    // "PROJECT_ID_SEQ", allocationSize = 1)
    private Long id;

    private String uuid;
    
    @NotNull
    private String title;

    private String description;

    private LocalDate dueDate;
    
    private Money budget;
    
    private User owner;
    
    private List<User> participants;
    
    public Task(String title, String description, User owner) {
        this.uuid = UUID.randomUUID().toString();
        update(title, description);
        this.owner = owner;
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }

//    public void schedule
    
    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String uuid() {
        return uuid;
    }

}
