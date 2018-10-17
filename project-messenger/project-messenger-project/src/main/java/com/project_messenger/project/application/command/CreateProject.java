package com.project_messenger.project.application.command;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class CreateProject extends GenericCommand<Project> {

    private String title;

    private String description;

    private String userIdentificator;
    
    public CreateProject(String title, String description, String userIdentificator) {
        super();
        this.title = title;
        this.description = description;
        this.userIdentificator = userIdentificator;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String userIdentificator() {
        return userIdentificator;
    }
}
