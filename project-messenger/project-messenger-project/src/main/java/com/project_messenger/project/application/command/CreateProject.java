package com.project_messenger.project.application.command;

import com.project_messenger.project.domain.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class CreateProject extends GenericCommand<Project> {

    private String title;

    private String description;

    public CreateProject(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }
}
