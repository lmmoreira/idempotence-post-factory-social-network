package br.com.project.leonardo.leonardobasics.dto;

import br.com.project.leonardo.leonardobasics.enums.SocialNetwork;
import br.com.project.leonardo.leonardobasics.enums.SocialNetworkStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class UserNetworkDTO implements Serializable {
    private SocialNetwork network;
    private String networkId;
    private SocialNetworkStatus status;

}
