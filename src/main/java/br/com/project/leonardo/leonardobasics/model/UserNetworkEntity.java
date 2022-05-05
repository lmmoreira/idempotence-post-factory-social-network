package br.com.project.leonardo.leonardobasics.model;

import br.com.project.leonardo.leonardobasics.enums.SocialNetwork;
import br.com.project.leonardo.leonardobasics.enums.SocialNetworkStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USUARIOS_REDES")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserNetworkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "REDE", length = 255, nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialNetwork name;

    @Column(name = "REDE_STATUS", length = 100, nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialNetworkStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO")
    private UserEntity user;

    @Column(name = "REDE_ID", length = 255)
    private String networkId;

}
