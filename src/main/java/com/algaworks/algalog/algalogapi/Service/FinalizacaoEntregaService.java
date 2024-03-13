package com.algaworks.algalog.algalogapi.Service;

import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Repository.EntregaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;

    private EntregaService entregaService;
    @Transactional
    public void finalizar(Long entregaId){

        Entrega entrega = entregaService.findById(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
