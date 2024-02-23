package com.algaworks.algalog.algalogapi.Controller;

import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Repository.EntregaRepository;
import com.algaworks.algalog.algalogapi.Service.EntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody  Entrega entrega){
        return entregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> findAll(){
        return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long id){
        return entregaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
