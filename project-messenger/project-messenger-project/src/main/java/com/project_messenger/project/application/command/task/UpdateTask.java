package com.project_messenger.project.application.command.task;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class UpdateTask extends GenericCommand<Project> {

    private String uuid;
    
    private String projectUuid;

    private String title;

    private String description;

    public UpdateTask(String projectUuid, String uuid, String title, String description) {
        super();
        this.uuid = uuid;
        this.projectUuid = projectUuid;
        this.title = title;
        this.description = description;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String projectUuid() {
        return projectUuid;
    }
    
    public String uuid() {
        return uuid;
    }
}
