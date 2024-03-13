package com.algaworks.algalog.algalogapi.Model;

import com.algaworks.algalog.algalogapi.Model.Enum.StatusEntrega;
import com.algaworks.algalog.algalogapi.Model.Exception.EntidadeNaoEncontradaException;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "entrega",cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusEntrega Status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime data_pedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime Data_finalizacao;


    public Ocorrencia addOcorencia(String descricao) {

        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.setEntrega(this);

        this.getOcorrencias().add(ocorrencia);
        return ocorrencia;
    }

    public void finalizar() {
        if(!podeSerFinalizada()){
            throw new EntidadeNaoEncontradaException("Entrega não pode ser finalizada");
        }
        this.setStatus(StatusEntrega.FINALIZADA);
        this.setData_finalizacao(OffsetDateTime.now());
    }

    public boolean podeSerFinalizada(){
        return this.getStatus().equals(StatusEntrega.PENDENTE);
    }
}
