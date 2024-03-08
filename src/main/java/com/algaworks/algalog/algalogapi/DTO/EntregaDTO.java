package com.algaworks.algalog.algalogapi.DTO;

import com.algaworks.algalog.algalogapi.Model.Cliente;
import com.algaworks.algalog.algalogapi.Model.Destinatario;
import com.algaworks.algalog.algalogapi.Model.Enum.StatusEntrega;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaDTO {

    private Long id;
    @Valid
    @NotNull
    private ClienteDTO cliente;
    @Valid
    @NotNull
    @Embedded
    private Destinatario destinatario;
    @NotNull
    private BigDecimal taxa;

    private StatusEntrega Status;

    private OffsetDateTime data_pedido;

}
