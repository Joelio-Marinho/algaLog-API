package com.algaworks.algalog.algalogapi.Model;

import com.algaworks.algalog.algalogapi.Model.Enum.StatusEntrega;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteID.class)
    @Valid
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Embedded
    @JoinColumn(name = "destinatario_id")
    private Destinatario destinatario;

    private BigDecimal taxa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusEntrega Status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime data_pedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime Data_finalizacao;

}
