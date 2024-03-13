package com.algaworks.algalog.algalogapi.Controller;

import com.algaworks.algalog.algalogapi.DTO.OcorrenciaDTO;
import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Model.Ocorrencia;
import com.algaworks.algalog.algalogapi.Service.EntregaService;
import com.algaworks.algalog.algalogapi.Service.RegistroOcorenciaService;
import com.algaworks.algalog.algalogapi.common.MapperAssemble;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {

    private EntregaService entregaService;

    private MapperAssemble mapperAssemble;

    private RegistroOcorenciaService registroOcorenciaService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar (@PathVariable Long id, @Valid @RequestBody OcorrenciaDTO ocorrenciaDTO){
        Ocorrencia ocorrencia = registroOcorenciaService.registrar(id,ocorrenciaDTO.getDescricao());

        return mapperAssemble.toDto(ocorrencia,OcorrenciaDTO.class);
    }

    @GetMapping
    public List<Ocorrencia> listar(@PathVariable Long id){
        Entrega entrega = entregaService.findById(id);
        return entrega.getOcorrencias();
    }
}
