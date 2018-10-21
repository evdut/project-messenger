package com.project_messenger.rest.project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.project_messenger.project.application.command.AddBudgetToProject;
import com.project_messenger.project.application.command.CreateProject;
import com.project_messenger.project.application.command.FinishProject;
import com.project_messenger.project.application.command.InviteUserToProject;
import com.project_messenger.project.application.command.ProjectCommandInvoker;
import com.project_messenger.project.application.command.ScheduleProject;
import com.project_messenger.project.application.command.StartProject;
import com.project_messenger.project.application.command.UpdateProject;
import com.project_messenger.project.application.command.task.AddCostsToTask;
import com.project_messenger.project.application.command.task.CreateTask;
import com.project_messenger.project.application.command.task.FinishTask;
import com.project_messenger.project.application.command.task.InviteUserToTask;
import com.project_messenger.project.application.command.task.ScheduleTask;
import com.project_messenger.project.application.command.task.UpdateTask;
import com.project_messenger.project.domain.model.Project;
import com.project_messenger.rest.project.api.AddBudgetRequestBody;
import com.project_messenger.rest.project.api.CreateUpdateProjectRequestBody;
import com.project_messenger.rest.project.api.InviteUserToProjectRequestBody;
import com.project_messenger.rest.project.api.ScheduleProjectRequestBody;
import com.project_messenger.rest.project.api.task.CreateUpdateTaskRequestBody;

@Path("/projects")
@ApplicationScoped
public class ProjectApi {

    @Inject
    private ProjectCommandInvoker projectCommandInvoker;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project create(CreateUpdateProjectRequestBody body) {
        return projectCommandInvoker.command(new CreateProject(body.title(), body.description(), "test@test.com"));
    }

    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project update(CreateUpdateProjectRequestBody body, @PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new UpdateProject(body.title(), body.description(), uuid));
    }

    @PUT
    @Path("/{uuid}/start")
    @Produces(MediaType.APPLICATION_JSON)
    public Project start(@PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new StartProject(uuid));
    }

    @PUT
    @Path("/{uuid}/finish")
    @Produces(MediaType.APPLICATION_JSON)
    public Project finish(@PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new FinishProject(uuid));
    }

    @PUT
    @Path("/{uuid}/schedule")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project schedule(ScheduleProjectRequestBody body, @PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new ScheduleProject(uuid, body.dueDate()));
    }

    @PUT
    @Path("/{uuid}/budget")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project budget(AddBudgetRequestBody body, @PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new AddBudgetToProject(uuid, body.budget()));
    }

    @PUT
    @Path("/{uuid}/schedule-implicitly")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project scheduleImplicitly(ScheduleProjectRequestBody body,
            @PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new ScheduleProject(uuid, body.dueDate(), true));
    }

    @PUT
    @Path("/{uuid}/budget-implicitly")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project budgetImplicitly(AddBudgetRequestBody body, @PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new AddBudgetToProject(uuid, body.budget(), true));
    }

    @PUT
    @Path("/{uuid}/invite")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project inviteUser(InviteUserToProjectRequestBody body, @PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new InviteUserToProject(uuid, body.userIdentificator()));
    }

    @POST
    @Path("/{uuid}/tasks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project createTask(CreateUpdateTaskRequestBody body, @PathParam(value = "uuid") @NotNull String uuid) {
        return projectCommandInvoker.command(new CreateTask(uuid, body.title(), body.description(), "test@test.com"));
    }

    @PUT
    @Path("/{uuid}/tasks/{taskUuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project updateTask(CreateUpdateTaskRequestBody body, @PathParam(value = "uuid") @NotNull String uuid,
            @PathParam(value = "taskUuid") @NotNull String taskUuid) {
        return projectCommandInvoker.command(new UpdateTask(uuid, taskUuid, body.title(), body.description()));
    }

    @PUT
    @Path("/{uuid}/tasks/{taskUuid}/finish")
    @Produces(MediaType.APPLICATION_JSON)
    public Project finishTask(@PathParam(value = "uuid") @NotNull String uuid,
            @PathParam(value = "taskUuid") @NotNull String taskUuid) {
        return projectCommandInvoker.command(new FinishTask(uuid, taskUuid));
    }

    @PUT
    @Path("/{uuid}/tasks/{taskUuid}/schedule")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project scheduleTask(ScheduleProjectRequestBody body, @PathParam(value = "uuid") @NotNull String uuid,
            @PathParam(value = "taskUuid") @NotNull String taskUuid) {
        return projectCommandInvoker.command(new ScheduleTask(uuid, taskUuid, body.dueDate()));
    }

    @PUT
    @Path("/{uuid}/tasks/{taskUuid}/budget")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project budgetTask(AddBudgetRequestBody body, @PathParam(value = "uuid") @NotNull String uuid,
            @PathParam(value = "taskUuid") @NotNull String taskUuid) {
        return projectCommandInvoker.command(new AddCostsToTask(uuid, taskUuid, body.budget()));
    }

    @PUT
    @Path("/{uuid}/tasks/{taskUuid}/schedule-implicitly")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project scheduleTaskImplicitly(ScheduleProjectRequestBody body,
            @PathParam(value = "uuid") @NotNull String uuid, @PathParam(value = "taskUuid") @NotNull String taskUuid) {
        return projectCommandInvoker.command(new ScheduleTask(uuid, taskUuid, body.dueDate(), true));
    }

    @PUT
    @Path("/{uuid}/tasks/{taskUuid}/budget-implicitly")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project budgetTaskImplicitly(AddBudgetRequestBody body, @PathParam(value = "uuid") @NotNull String uuid,
            @PathParam(value = "taskUuid") @NotNull String taskUuid) {
        return projectCommandInvoker.command(new AddCostsToTask(uuid, taskUuid, body.budget(), true));
    }

    @PUT
    @Path("/{uuid}/tasks/{taskUuid}/invite")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Project inviteUser(InviteUserToProjectRequestBody body, @PathParam(value = "uuid") @NotNull String uuid,
            @PathParam(value = "taskUuid") @NotNull String taskUuid) {
        return projectCommandInvoker.command(new InviteUserToTask(uuid, taskUuid, body.userIdentificator()));
    }
}
