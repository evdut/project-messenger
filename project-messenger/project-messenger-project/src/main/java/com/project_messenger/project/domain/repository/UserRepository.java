package com.project_messenger.project.domain.repository;

import com.project_messenger.project.domain.model.User;

public interface UserRepository {

    User user(String identificator);
    
}
