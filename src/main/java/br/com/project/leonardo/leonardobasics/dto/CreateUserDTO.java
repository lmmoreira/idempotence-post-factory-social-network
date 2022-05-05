package br.com.project.leonardo.leonardobasics.dto;

import br.com.project.leonardo.leonardobasics.enums.SocialNetwork;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class CreateUserDTO implements Serializable {
    private String name;
    private Date birthDate;
    private Set<SocialNetwork> networks;
}
