package com.project_messenger.project.application.command.handler.task;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.project_messenger.project.application.command.task.UpdateTask;
import com.project_messenger.project.domain.model.Project;
import com.project_messenger.project.domain.model.Task;
import com.project_messenger.project.domain.repository.ProjectRepository;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = UpdateTask.class)
public class UpdateTaskCommandHandler implements Handler<UpdateTask> {

    @PostConstruct
    private void init() {

    }

    @PreDestroy
    private void destroy() {

    }

    @Inject
    private ProjectRepository projectRepository;

    public void handle(UpdateTask command) {
        Project project = projectRepository.project(command.projectUuid());
        if (project == null) {
            throw new RuntimeException("Project '" + command.projectUuid() + "' does not exist");
        }

        Task task = project.task(command.uuid());
        task.update(command.title(), command.description());
        project.updateTask(task);
        projectRepository.update(project);
        command.setResult(project);
    }
}
