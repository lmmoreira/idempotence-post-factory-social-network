package br.com.project.leonardo.leonardobasics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class GreetingUserDTO implements Serializable {
    private Long id;
    private String name;
    private Date birthDate;
    private String message;
}
