package br.com.project.leonardo.leonardobasics.controller.user;

import br.com.project.leonardo.leonardobasics.configuration.properties.WellcomeMessageProperties;
import br.com.project.leonardo.leonardobasics.controller.ControllerIntegrationTest;
import br.com.project.leonardo.leonardobasics.dto.GreetingUserDTO;
import br.com.project.leonardo.leonardobasics.dto.UserDTO;
import br.com.project.leonardo.leonardobasics.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerIntegrationTest extends ControllerIntegrationTest {

    @Autowired
    private WellcomeMessageProperties wellcomeMessageProperties;

    @Autowired
    private UserService userService;

    @Autowired
    private ConversionService conversionService;

    @Test
    public void getGreetingsByUserTest() throws Exception {
        UserDTO dto = conversionService.convert(userService.getById(1L), UserDTO.class);
        final GreetingUserDTO greetingUserDTO = GreetingUserDTO.builder()
                .id(dto.getId())
                .name(dto.getName())
                .birthDate(dto.getBirthDate())
                .message(wellcomeMessageProperties.getMessage()).build();

        mvc.perform(MockMvcRequestBuilders.get("/api/users/greeting/1/me").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(greetingUserDTO))));
    }

}
