package com.project_messenger.project.application.command.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import com.project_messenger.project.application.command.CreateProject;
import com.project_messenger.project.domain.Project;

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

//	@Inject
//	ProjectRepository projectRepository;

	public void handle(CreateProject command) {
	    command.setResult(new Project(command.title(), command.description()));
	}
}
