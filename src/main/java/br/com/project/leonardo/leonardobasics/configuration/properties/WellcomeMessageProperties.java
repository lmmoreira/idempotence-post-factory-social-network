package br.com.project.leonardo.leonardobasics.configuration.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "wellcome")
@ConstructorBinding
@Getter
@AllArgsConstructor
public class WellcomeMessageProperties {
    @NotBlank
    private final String message;
}
