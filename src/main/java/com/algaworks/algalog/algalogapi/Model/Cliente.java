package com.algaworks.algalog.algalogapi.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente implements Serializable {

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
