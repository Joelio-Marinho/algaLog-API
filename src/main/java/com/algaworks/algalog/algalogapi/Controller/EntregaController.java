package com.algaworks.algalog.algalogapi.Controller;

import com.algaworks.algalog.algalogapi.DTO.EntregaDTO;
import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Repository.EntregaRepository;
import com.algaworks.algalog.algalogapi.Service.EntregaService;
import com.algaworks.algalog.algalogapi.Service.FinalizacaoEntregaService;
import com.algaworks.algalog.algalogapi.common.MapperAssemble;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaService entregaService;

    private EntregaRepository entregaRepository;

    private MapperAssemble mapperAssemble;
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(@Valid @RequestBody  EntregaDTO entregaDTO){
        Entrega entrega = entregaService.solicitar(mapperAssemble.toModel(entregaDTO,Entrega.class));
         return mapperAssemble.toDto(entrega, EntregaDTO.class);
    }

    @GetMapping
    public List<Entrega> findAll(){
       return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long id){
        return entregaRepository.findById(id)
                .map( entrega -> ResponseEntity.ok(mapperAssemble.toDto(entrega, EntregaDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar( @PathVariable Long id){
        finalizacaoEntregaService.finalizar(id);
    }
}
