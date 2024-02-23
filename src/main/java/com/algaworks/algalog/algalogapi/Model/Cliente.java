package com.algaworks.algalog.algalogapi.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente implements Serializable {

    @NotNull(groups = ValidationGroups.ClienteID.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max=60)
    @Column(name = "nome")
    private String nome;
    @NotBlank
    @Email
    @Size(max=255)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max= 20)
    @Column(name = "telefone")
    private String telefone;

}
