package com.project_messenger.project.application.command.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.project_messenger.project.application.command.CreateProject;
import com.project_messenger.project.domain.model.Project;
import com.project_messenger.project.domain.model.User;
import com.project_messenger.project.domain.repository.ProjectRepository;
import com.project_messenger.project.domain.repository.UserRepository;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = CreateProject.class)
public class CreateProjectCommandHandler implements Handler<CreateProject> {

	@PostConstruct
	private void init() {

	}

	@PreDestroy
	private void destroy() {

	}

	@Inject
	private ProjectRepository projectRepository;
	
	@Inject
    private UserRepository userReposotory;

	public void handle(CreateProject command) {
	    User user = userReposotory.user(command.userIdentificator());
	    if(user == null) {
	        throw new RuntimeException("User '" + command.userIdentificator() + "' does not exist");
	    }
	    Project project = new Project(command.title(), command.description(), "USD", user);
	    projectRepository.persist(project);
	    command.setResult(project);
	}
}
