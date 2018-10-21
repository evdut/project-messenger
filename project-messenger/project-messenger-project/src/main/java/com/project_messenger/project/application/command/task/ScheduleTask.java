package com.project_messenger.project.application.command.task;

import java.time.LocalDate;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class ScheduleTask extends GenericCommand<Project> {

    private String projectUuid;
    
    private String uuid;

    private LocalDate dueDate;

    private boolean implicitly;

    public ScheduleTask(String projectUuid, String uuid, LocalDate dueDate) {
        this(projectUuid, uuid, dueDate, false);
    }

    public ScheduleTask(String projectUuid, String uuid, LocalDate dueDate, boolean implicitly) {
        super();
        this.projectUuid = projectUuid;
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

    public String projectUuid() {
        return projectUuid;
    }
    
    public boolean implicitly() {
        return implicitly;
    }
}
