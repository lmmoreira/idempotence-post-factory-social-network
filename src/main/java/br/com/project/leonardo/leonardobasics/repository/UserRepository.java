package br.com.project.leonardo.leonardobasics.repository;

import br.com.project.leonardo.leonardobasics.model.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @EntityGraph(attributePaths = {"networks"})
    Optional<UserEntity> findById(Long id);
    @EntityGraph(attributePaths = {"networks"})
    Optional<UserEntity> findByHash(String hash);
}
