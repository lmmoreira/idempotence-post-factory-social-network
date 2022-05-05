package br.com.project.leonardo.leonardobasics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USUARIOS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "NOME", length = 255, nullable = false, unique = true)
    private String name;

    @Column(name = "HASH", length = 255, nullable = false, unique = true)
    private String hash;

    @Temporal(TemporalType.DATE)
    @Column(name = "NASCIMENTO", nullable = false)
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserNetworkEntity> networks;

    public void addNetwork(UserNetworkEntity entity) {
        if (networks == null) {
            networks = new HashSet<>();
        }

        entity.setUser(this);
        networks.add(entity);
    }

}
