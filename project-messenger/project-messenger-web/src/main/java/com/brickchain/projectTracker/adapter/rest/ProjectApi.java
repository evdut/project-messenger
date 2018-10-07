package com.brickchain.projectTracker.adapter.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.project_messenger.project.application.command.CreateProject;
import com.project_messenger.project.application.command.ProjectCommandInvoker;

@Path("/project")
@ApplicationScoped
public class ProjectApi {

	@Inject
	private ProjectCommandInvoker projectCommandInvoker;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public void create(CreateProject command) {
	    projectCommandInvoker.command(command);
    }
}
