package com.algaworks.algalog.algalogapi.Model;

import com.algaworks.algalog.algalogapi.Model.Enum.StatusEntrega;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private StatusEntrega Status;

    private LocalDateTime data_pedido;

    private LocalDateTime Data_finalizacao;

}
