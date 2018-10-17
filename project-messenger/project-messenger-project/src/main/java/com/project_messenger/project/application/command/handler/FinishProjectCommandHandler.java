package com.project_messenger.project.application.command.handler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.project_messenger.project.application.command.FinishProject;
import com.project_messenger.project.domain.model.Project;
import com.project_messenger.project.domain.repository.ProjectRepository;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = FinishProject.class)
public class FinishProjectCommandHandler implements Handler<FinishProject> {

    @PostConstruct
    private void init() {

    }

    @PreDestroy
    private void destroy() {

    }

    @Inject
    private ProjectRepository projectRepository;

    public void handle(FinishProject command) {
        Project project = projectRepository.project(command.uuid());
        if (project == null) {
            throw new RuntimeException("Project '" + command.uuid() + "' does not exist");
        }
        project.finish();
        projectRepository.update(project);
    }
}
