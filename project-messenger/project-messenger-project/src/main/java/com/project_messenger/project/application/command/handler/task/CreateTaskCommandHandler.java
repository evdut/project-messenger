package com.project_messenger.project.application.command.handler.task;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.project_messenger.project.application.command.task.CreateTask;
import com.project_messenger.project.domain.model.Project;
import com.project_messenger.project.domain.model.Task;
import com.project_messenger.project.domain.model.User;
import com.project_messenger.project.domain.repository.ProjectRepository;
import com.project_messenger.project.domain.repository.UserRepository;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = CreateTask.class)
public class CreateTaskCommandHandler implements Handler<CreateTask> {

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

    public void handle(CreateTask command) {
        Project project = projectRepository.project(command.projectUuid());
        if (project == null) {
            throw new RuntimeException("Project '" + command.projectUuid() + "' does not exist");
        }

        User user = userReposotory.user(command.userIdentificator());
        if (user == null) {
            throw new RuntimeException("User '" + command.userIdentificator() + "' does not exist");
        }

        project.addTask(new Task(command.title(), command.description(), user));
        projectRepository.update(project);
        command.setResult(project);
    }
}
