package br.com.project.leonardo.leonardobasics.converter;

import br.com.project.leonardo.leonardobasics.dto.GreetingUserDTO;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import br.com.project.leonardo.leonardobasics.configuration.properties.WellcomeMessageProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityToGreetingUserDTOConverter implements Converter<UserEntity, GreetingUserDTO> {

    private final WellcomeMessageProperties wellcomeMessageProperties;

    @Override
    public GreetingUserDTO convert(UserEntity entity) {
        return GreetingUserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .birthDate(entity.getBirthDate())
                .message(wellcomeMessageProperties.getMessage()).build();
    }
}
