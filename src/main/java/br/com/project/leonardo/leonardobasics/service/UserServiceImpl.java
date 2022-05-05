package br.com.project.leonardo.leonardobasics.service;

import br.com.project.leonardo.leonardobasics.exception.UserNotFoundException;
import br.com.project.leonardo.leonardobasics.model.UserEntity;
import br.com.project.leonardo.leonardobasics.repository.UserRepository;
import br.com.project.leonardo.leonardobasics.service.network.UserNetworkFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserNetworkFactory userNetworkFactory;

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public UserEntity createUser(UserEntity entity) {
        return assureIndepotence(entity);
    }

    public UserEntity assureIndepotence(UserEntity entity) {
        return userRepository.findByHash(entity.getHash()).orElseGet(() -> {
            UserEntity user = userRepository.save(entity);
            createSocialNetwork(user);
            return user;
        });
    }

    public void createSocialNetwork(UserEntity entity) {
        entity.getNetworks().forEach(it -> userNetworkFactory.createUser(it.getName(), entity));
    }
}
