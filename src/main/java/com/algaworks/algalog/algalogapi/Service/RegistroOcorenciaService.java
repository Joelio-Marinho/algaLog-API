package com.algaworks.algalog.algalogapi.Service;

import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Model.Ocorrencia;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistroOcorenciaService {

    private EntregaService entregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = entregaService.findById(entregaId);
        return entrega.addOcorencia(descricao);
    }
}
