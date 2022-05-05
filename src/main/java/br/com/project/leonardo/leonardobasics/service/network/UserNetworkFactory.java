package br.com.project.leonardo.leonardobasics.service.network;

import br.com.project.leonardo.leonardobasics.enums.SocialNetwork;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserNetworkFactory {
    private final Set<UserNetworkStrategy> strategies;
    private Map<SocialNetwork, UserNetworkStrategy> networkFactory;

    @PostConstruct
    private void init() {
        networkFactory = strategies.stream().collect(Collectors.toMap(UserNetworkStrategy::getNetwork, item -> item));
    }

    public void createUser(SocialNetwork network, UserEntity entity) {
        networkFactory.get(network).createUser(entity);
    }

}
