package com.project_messenger.rest.project.api;

import java.io.Serializable;

public class CreateUpdateProjectRequestBody implements Serializable {

    private String title;

    private String description;
    
    public CreateUpdateProjectRequestBody(String title, String description) {
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
