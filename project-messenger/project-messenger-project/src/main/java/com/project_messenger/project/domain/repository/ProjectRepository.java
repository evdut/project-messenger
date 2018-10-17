package com.project_messenger.project.domain.repository;

import com.project_messenger.project.domain.model.Project;

public interface ProjectRepository {

    Project project(String uuid);
    void persist(Project project);
    void update(Project project);
}
