package br.com.project.leonardo.leonardobasics.service.network;

import br.com.project.leonardo.leonardobasics.enums.SocialNetwork;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Order(0)
public class TwitterStrategy implements UserNetworkStrategy {
    private final Map<SocialNetwork, UserNetworkStrategy> networkFactory = new HashMap<>();

    @Override
    public SocialNetwork getNetwork() {
        return SocialNetwork.TWITTER;
    }

    @Override
    public void createUser(UserEntity userEntity) {
        System.out.println("To create on Twitter");
    }
}
