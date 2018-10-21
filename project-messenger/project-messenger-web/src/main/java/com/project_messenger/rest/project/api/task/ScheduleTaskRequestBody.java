package com.project_messenger.rest.project.api.task;

import java.io.Serializable;
import java.time.LocalDate;

public class ScheduleTaskRequestBody implements Serializable {

    private LocalDate dueDate;


    public ScheduleTaskRequestBody(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate dueDate() {
        return dueDate;
    }
}
