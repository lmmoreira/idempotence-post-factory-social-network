package br.com.project.leonardo.leonardobasics.converter;

import br.com.project.leonardo.leonardobasics.dto.UserDTO;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDTOToUserEntityConverter implements Converter<UserDTO, UserEntity> {

    @Override
    public UserEntity convert(UserDTO dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .birthDate(dto.getBirthDate()).build();
    }
}
