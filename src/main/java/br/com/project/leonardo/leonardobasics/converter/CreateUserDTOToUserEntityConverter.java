package br.com.project.leonardo.leonardobasics.converter;

import br.com.project.leonardo.leonardobasics.dto.CreateUserDTO;
import br.com.project.leonardo.leonardobasics.enums.SocialNetworkStatus;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import br.com.project.leonardo.leonardobasics.model.UserNetworkEntity;
import br.com.project.leonardo.leonardobasics.utils.Hash;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreateUserDTOToUserEntityConverter implements Converter<CreateUserDTO, UserEntity> {

    @Override
    public UserEntity convert(CreateUserDTO dto) {
        UserEntity user = UserEntity.builder()
                .name(dto.getName())
                .hash(Hash.encode(dto.getName()))
                .birthDate(dto.getBirthDate()).build();
        dto.getNetworks().forEach(it ->  user.addNetwork(UserNetworkEntity.builder().name(it).status(SocialNetworkStatus.PENDING).build()));
        return user;
    }
}
