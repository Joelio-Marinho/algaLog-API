package com.algaworks.algalog.algalogapi.Service;

import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Model.Enum.StatusEntrega;
import com.algaworks.algalog.algalogapi.Repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class EntregaService {

    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar( Entrega entrega){
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setData_pedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
