package com.project_messenger.project.application.command;

import java.time.LocalDate;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class ScheduleProject extends GenericCommand<Project> {

    private String uuid;

    private LocalDate dueDate;

    private boolean implicitly;

    public ScheduleProject(String uuid, LocalDate dueDate) {
        this(uuid, dueDate, false);
    }

    public ScheduleProject(String uuid, LocalDate dueDate, boolean implicitly) {
        super();
        this.dueDate = dueDate;
        this.uuid = uuid;
        this.implicitly =  implicitly;
    }

    public LocalDate dueDate() {
        return dueDate;
    }

    public String uuid() {
        return uuid;
    }

    public boolean implicitly() {
        return implicitly;
    }
}
