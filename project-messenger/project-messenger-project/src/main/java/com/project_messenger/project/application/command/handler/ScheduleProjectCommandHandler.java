package com.project_messenger.project.application.command.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.project_messenger.project.application.command.AddBudgetToProject;
import com.project_messenger.project.application.command.ScheduleProject;
import com.project_messenger.project.domain.model.Project;
import com.project_messenger.project.domain.repository.ProjectRepository;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = ScheduleProject.class)
public class ScheduleProjectCommandHandler implements Handler<ScheduleProject> {

	@PostConstruct
	private void init() {

	}

	@PreDestroy
	private void destroy() {

	}

	@Inject
	private ProjectRepository projectRepository;

	public void handle(ScheduleProject command) {
	    Project project = projectRepository.project(command.uuid());
        if (project == null) {
            throw new RuntimeException("Project '" + command.uuid() + "' does not exist");
        }
        
        if(command.implicitly()) {
            project.scheduleImplicitly(command.dueDate());
        } else {
            project.schedule(command.dueDate());
        }
	    projectRepository.update(project);
	    command.setResult(project);
	}
}
