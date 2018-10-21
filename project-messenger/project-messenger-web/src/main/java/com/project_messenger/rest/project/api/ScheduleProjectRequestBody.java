package com.project_messenger.rest.project.api;

import java.time.LocalDate;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class ScheduleProjectRequestBody extends GenericCommand<Project> {

    private LocalDate dueDate;

    public ScheduleProjectRequestBody(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate dueDate() {
        return dueDate;
    }
}
