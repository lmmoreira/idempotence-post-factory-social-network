package br.com.project.leonardo.leonardobasics.converter;

import br.com.project.leonardo.leonardobasics.configuration.properties.WellcomeMessageProperties;
import br.com.project.leonardo.leonardobasics.dto.UserNetworkDTO;
import br.com.project.leonardo.leonardobasics.model.UserNetworkEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserNetworkEntityToUserNetworkDTOConverter implements Converter<UserNetworkEntity, UserNetworkDTO> {

    private WellcomeMessageProperties wellcomeMessageProperties;

    @Override
    public UserNetworkDTO convert(UserNetworkEntity entity) {
        return UserNetworkDTO.builder()
                .network(entity.getName())
                .status(entity.getStatus())
                .networkId(entity.getNetworkId()).build();
    }
}
