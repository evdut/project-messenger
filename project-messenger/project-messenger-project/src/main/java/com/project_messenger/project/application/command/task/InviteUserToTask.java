package com.project_messenger.project.application.command.task;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class InviteUserToTask extends GenericCommand<Project> {

    private String uuid;
    
    private String projectUuid;
    
    private String userIdentificator;
    
    public InviteUserToTask(String projectUuid, String uuid, String userIdentificator) {
        super();
        this.userIdentificator = userIdentificator;
        this.uuid = uuid;
        this.projectUuid = projectUuid;
    }

    public String userIdentificator() {
        return userIdentificator;
    }
    
    public String uuid() {
        return uuid;
    }
    
    public String projectUuid() {
        return projectUuid;
    }
}
