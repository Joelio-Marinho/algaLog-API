package com.algaworks.algalog.algalogapi.Model;

import com.algaworks.algalog.algalogapi.Model.Enum.StatusEntrega;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private LocalDateTime data_pedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime Data_finalizacao;

}
