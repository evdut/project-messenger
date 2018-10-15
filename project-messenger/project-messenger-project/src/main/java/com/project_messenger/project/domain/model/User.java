package com.project_messenger.project.domain.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class User implements Serializable {

    @NotNull
    private String identificator;
    
    @NotNull
    private String name;
    
    public User(String identificator, String name) {
        this.identificator = identificator;
        this.name = name;
    }

    public String identificator() {
        return identificator;
    }

    public String name() {
        return name;
    }
    
}
