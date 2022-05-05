package br.com.project.leonardo.leonardobasics.converter;

import br.com.project.leonardo.leonardobasics.configuration.properties.WellcomeMessageProperties;
import br.com.project.leonardo.leonardobasics.dto.UserDTO;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserEntityToUserDTOConverter implements Converter<UserEntity, UserDTO> {

    private WellcomeMessageProperties wellcomeMessageProperties;

    private final UserNetworkEntityToUserNetworkDTOConverter userNetworkEntityToUserNetworkDTOConverter;

    @Override
    public UserDTO convert(UserEntity entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .networks(entity.getNetworks().stream().map(userNetworkEntityToUserNetworkDTOConverter::convert).collect(Collectors.toSet()))
                .birthDate(entity.getBirthDate()).build();
    }
}
