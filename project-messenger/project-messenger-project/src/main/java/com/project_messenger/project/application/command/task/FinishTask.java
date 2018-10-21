package com.project_messenger.project.application.command.task;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class FinishTask extends GenericCommand<Project> {

    private String uuid;
    
    private String projectUuid;
   
    public FinishTask(String projectUuid, String uuid) {
        super();
        this.uuid = uuid;
    }
    
    public String uuid() {
        return uuid;
    }
    
    public String projectUuid() {
        return projectUuid;
    }
}
