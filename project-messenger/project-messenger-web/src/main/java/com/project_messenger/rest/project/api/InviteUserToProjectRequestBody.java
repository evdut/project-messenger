package com.project_messenger.rest.project.api;

import java.io.Serializable;

import com.project_messenger.project.domain.model.Project;

import net.evdut.cqrs.framework.api.GenericCommand;

public class InviteUserToProjectRequestBody implements Serializable {

    private String userIdentificator;
    
    public InviteUserToProjectRequestBody(String userIdentificator) {
        this.userIdentificator = userIdentificator;
    }

    public String userIdentificator() {
        return userIdentificator;
    }

}
