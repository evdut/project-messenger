package com.project_messenger.project.application.command;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class FinishProject extends GenericCommand<Project> {

    private String uuid;
   
    public FinishProject(String uuid) {
        super();
        this.uuid = uuid;
    }
    
    public String uuid() {
        return uuid;
    }
}
