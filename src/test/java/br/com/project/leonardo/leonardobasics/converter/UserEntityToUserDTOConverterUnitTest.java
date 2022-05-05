package br.com.project.leonardo.leonardobasics.converter;

import br.com.project.leonardo.leonardobasics.UnitTests;
import br.com.project.leonardo.leonardobasics.dto.UserDTO;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static br.com.project.leonardo.leonardobasics.assertions.dto.UserDTOAssert.assertThat;


public class UserEntityToUserDTOConverterUnitTest extends UnitTests {

    private UserEntityToUserDTOConverter userEntityToUserDTOConverterTest;

    @BeforeEach
    public void initUseCase() {
        userEntityToUserDTOConverterTest = new UserEntityToUserDTOConverter(new UserNetworkEntityToUserNetworkDTOConverter());
    }

    @Test
    public void convertEntitySucess() {
        UserDTO dto = userEntityToUserDTOConverterTest.convert(getEntity());
        assertThat(dto).hasName().hasSameName((getEntity().getName())).isSameObject(getDto());

    }

    private UserEntity getEntity() {
        return UserEntity.builder().name("Leo").networks(new HashSet<>()).build();
    }

    private UserDTO getDto() {
        return UserDTO.builder().name("Leo").networks(new HashSet<>()).build();
    }

}
