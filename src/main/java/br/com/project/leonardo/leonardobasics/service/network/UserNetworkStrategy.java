package br.com.project.leonardo.leonardobasics.service.network;

import br.com.project.leonardo.leonardobasics.enums.SocialNetwork;
import br.com.project.leonardo.leonardobasics.model.UserEntity;

public interface UserNetworkStrategy {
    SocialNetwork getNetwork();

    void createUser(UserEntity userEntity);
}
