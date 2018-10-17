package com.project_messenger.project.application.command;

import org.javamoney.moneta.Money;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class AddBudgetToProject extends GenericCommand<Project> {

    private String uuid;
    
    private Money budget;
    
    private boolean implicitly;
    
    public AddBudgetToProject(String uuid, Money budget) {
        this(uuid, budget, false);
    }
    
    public AddBudgetToProject(String uuid, Money budget, boolean implicitly) {
        super();
        this.budget = budget;
        this.uuid = uuid;
        this.implicitly = implicitly;
    }

    public Money budget() {
        return budget;
    }
    
    public String uuid() {
        return uuid;
    }
    
    public boolean implicitly() {
        return implicitly;
    }
}
