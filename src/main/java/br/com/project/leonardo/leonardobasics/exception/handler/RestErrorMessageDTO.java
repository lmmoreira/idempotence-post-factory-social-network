package br.com.project.leonardo.leonardobasics.exception.handler;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RestErrorMessageDTO implements Serializable {
    private String message;
}
