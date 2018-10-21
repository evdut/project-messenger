package com.project_messenger.project.application.command.task;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class CreateTask extends GenericCommand<Project> {

    private String projectUuid;

    private String title;

    private String description;

    private String userIdentificator;

    public CreateTask(String projectUuid, String title, String description, String userIdentificator) {
        super();
        this.projectUuid = projectUuid;
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

    public String projectUuid() {
        return projectUuid;
    }
}
