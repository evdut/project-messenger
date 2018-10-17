package com.project_messenger.project.application.command;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class InviteUserToProject extends GenericCommand<Project> {

    private String uuid;
    
    private String userIdentificator;
    
    public InviteUserToProject(String uuid, String userIdentificator) {
        super();
        this.userIdentificator = userIdentificator;
        this.uuid = uuid;
    }

    public String userIdentificator() {
        return userIdentificator;
    }
    
    public String uuid() {
        return uuid;
    }
}
