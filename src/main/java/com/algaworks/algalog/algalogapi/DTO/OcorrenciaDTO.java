package com.algaworks.algalog.algalogapi.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaDTO {

    private Long id;
    @NotBlank
    private String descricao;
    private OffsetDateTime dataRegistro;
}
