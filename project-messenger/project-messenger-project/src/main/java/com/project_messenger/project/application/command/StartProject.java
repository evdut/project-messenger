package com.project_messenger.project.application.command;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class StartProject extends GenericCommand<Project> {

    private String uuid;
   
    public StartProject(String uuid) {
        super();
        this.uuid = uuid;
    }
    
    public String uuid() {
        return uuid;
    }
}
