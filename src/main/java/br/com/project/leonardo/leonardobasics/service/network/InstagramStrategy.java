package br.com.project.leonardo.leonardobasics.service.network;

import br.com.project.leonardo.leonardobasics.enums.SocialNetwork;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Order(1)
public class InstagramStrategy implements UserNetworkStrategy {
    private final Map<SocialNetwork, UserNetworkStrategy> networkFactory = new HashMap<>();

    @Override
    public SocialNetwork getNetwork() {
        return SocialNetwork.INSTAGRAM;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        System.out.println("To create on Insta");
    }
}
