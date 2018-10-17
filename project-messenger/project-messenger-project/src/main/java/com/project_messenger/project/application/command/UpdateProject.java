package com.project_messenger.project.application.command;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class UpdateProject extends GenericCommand<Project> {

    private String uuid;
    
    private String title;

    private String description;
    
    public UpdateProject(String title, String description, String uuid) {
        super();
        this.title = title;
        this.description = description;
        this.uuid = uuid;
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
}
