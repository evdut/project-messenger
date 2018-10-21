package com.project_messenger.rest.project.api.task;

import java.io.Serializable;

public class CreateUpdateTaskRequestBody implements Serializable {

    private String title;

    private String description;
    
    public CreateUpdateTaskRequestBody(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }
}
