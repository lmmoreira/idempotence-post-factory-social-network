package br.com.project.leonardo.leonardobasics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private Date birthDate;
    private Set<UserNetworkDTO> networks;
}
