package br.com.project.leonardo.leonardobasics.controller;

import br.com.project.leonardo.leonardobasics.dto.CreateUserDTO;
import br.com.project.leonardo.leonardobasics.dto.GreetingUserDTO;
import br.com.project.leonardo.leonardobasics.dto.UserDTO;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import br.com.project.leonardo.leonardobasics.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@Tag(name = "user", description = "User API")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User Found"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "400", description = "Parametros obrigatorios nao foram informados.")
})
public class UserController extends AbstractController implements UserControllerInterface {

    private final ConversionService conversionService;
    private final UserService userService;

    @Override
    @GetMapping(value = "/{userId}", produces = "application/json")
    @Operation(summary = "Find User", description = "Find User")
    public UserDTO getUser(@PathVariable Long userId) {
        return conversionService.convert(userService.getById(userId), UserDTO.class);
    }

    @Override
    @GetMapping(value = "/greeting/{userId}/me", produces = "application/json")
    @Operation(summary = "Greets User", description = "Finds and Greets User")
    public GreetingUserDTO getGreetingsByUser(@PathVariable Long userId) {
        return conversionService.convert(userService.getById(userId), GreetingUserDTO.class);
    }

    @Override
    @PostMapping(value = "/createUser", produces = "application/json")
    @Operation(summary = "Creates User", description = "Creates User")
    public UserDTO createUser(@RequestBody CreateUserDTO user) {
        return conversionService.convert(userService.createUser(conversionService.convert(user, UserEntity.class)), UserDTO.class);
    }
}
