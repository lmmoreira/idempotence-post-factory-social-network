package br.com.project.leonardo.leonardobasics.controller;

import br.com.project.leonardo.leonardobasics.dto.CreateUserDTO;
import br.com.project.leonardo.leonardobasics.dto.GreetingUserDTO;
import br.com.project.leonardo.leonardobasics.dto.UserDTO;

public interface UserControllerInterface {
    UserDTO getUser(Long id);
    GreetingUserDTO getGreetingsByUser(Long id);
    UserDTO createUser(CreateUserDTO user);
}
