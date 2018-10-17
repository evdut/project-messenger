package com.project_messenger.project.application.command.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.project_messenger.project.application.command.StartProject;
import com.project_messenger.project.application.command.UpdateProject;
import com.project_messenger.project.domain.model.Project;
import com.project_messenger.project.domain.repository.ProjectRepository;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = StartProject.class)
public class StartProjectCommandHandler implements Handler<StartProject> {

    @PostConstruct
    private void init() {

    }

    @PreDestroy
    private void destroy() {

    }

    @Inject
    private ProjectRepository projectRepository;

    public void handle(StartProject command) {
        Project project = projectRepository.project(command.uuid());
        if (project == null) {
            throw new RuntimeException("Project '" + command.uuid() + "' does not exist");
        }
        project.start();
        projectRepository.update(project);
    }
}
