package com.project_messenger.rest.project.api.task;

import java.io.Serializable;

public class InviteUserToTaskRequestBody implements Serializable {

    private String userIdentificator;
    
    public InviteUserToTaskRequestBody(String uuid, String userIdentificator) {
        super();
        this.userIdentificator = userIdentificator;
    }

    public String userIdentificator() {
        return userIdentificator;
    }
}
