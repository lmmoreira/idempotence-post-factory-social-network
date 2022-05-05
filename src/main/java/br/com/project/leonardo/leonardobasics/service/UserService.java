package br.com.project.leonardo.leonardobasics.service;

import br.com.project.leonardo.leonardobasics.model.UserEntity;

public interface UserService {
    UserEntity getById(Long id);
    UserEntity createUser(UserEntity entity);
}
