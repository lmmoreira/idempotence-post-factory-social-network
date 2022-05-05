package br.com.project.leonardo.leonardobasics.assertions.dto;

import br.com.project.leonardo.leonardobasics.dto.UserDTO;
import org.assertj.core.api.AbstractAssert;

public class UserDTOAssert extends AbstractAssert<UserDTOAssert, UserDTO> {

    protected UserDTOAssert(UserDTO userDTO) {
        super(userDTO, UserDTOAssert.class);
    }

    public static UserDTOAssert assertThat(UserDTO actual) {
        return new UserDTOAssert(actual);
    }

    public UserDTOAssert hasName() {
        isNotNull();

        if (actual.getName().isEmpty()) {
            failWithMessage("Name is null %s", actual.getName());
        }

        return this;
    }

    public UserDTOAssert hasSameName(final String name) {
        isNotNull();

        if (!actual.getName().equals(name)) {
            failWithMessage("Same name %s but was %s", name, actual.getName());
        }

        return this;
    }

    public UserDTOAssert isSameObject(final UserDTO userDTO) {
        isNotNull();

        if (!actual.equals(userDTO)) {
            failWithMessage("Expected object %s but was %s", userDTO, actual);
        }

        return this;
    }
}
