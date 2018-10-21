package com.project_messenger.project.application.command.task;

import org.javamoney.moneta.Money;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class AddCostsToTask extends GenericCommand<Project> {

    private String uuid;
    
    private String projectUuid;
    
    private Money costs;
    
    private boolean implicitly;
    
    public AddCostsToTask(String projectUuid, String uuid, Money budget) {
        this(projectUuid, uuid, budget, false);
    }
    
    public AddCostsToTask(String projectUuid, String uuid, Money costs, boolean implicitly) {
        super();
        this.projectUuid = projectUuid;
        this.costs = costs;
        this.uuid = uuid;
        this.implicitly = implicitly;
    }

    public Money costs() {
        return costs;
    }
    
    public String uuid() {
        return uuid;
    }
    
    public String projectUuid() {
        return projectUuid;
    }
    
    public boolean implicitly() {
        return implicitly;
    }
}
