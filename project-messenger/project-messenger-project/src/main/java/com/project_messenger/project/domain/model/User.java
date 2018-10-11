package com.project_messenger.project.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class User implements Serializable {

    private Long id;

    @NotNull
    private String uuid;
    
    @NotNull
    private String name;

    private List<Project> projects;
    
    public User(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String uuid() {
        return uuid;
    }

    public String name() {
        return name;
    }

    public List<Project> projects() {
        return projects;
    }
}
