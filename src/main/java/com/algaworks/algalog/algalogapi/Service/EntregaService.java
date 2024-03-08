package com.algaworks.algalog.algalogapi.Service;

import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Model.Enum.StatusEntrega;
import com.algaworks.algalog.algalogapi.Model.Exception.ClienteException;
import com.algaworks.algalog.algalogapi.Model.Exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.algalogapi.Repository.ClienteRepository;
import com.algaworks.algalog.algalogapi.Repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class EntregaService {

    private ClienteService clienteService;

    private EntregaRepository entregaRepository;

   @Transactional
    public Entrega solicitar( Entrega entrega){
        var cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setData_pedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }

    public Entrega findById( Long id){
       return entregaRepository.findById(id)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
