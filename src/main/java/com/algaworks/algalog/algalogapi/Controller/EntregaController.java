package com.algaworks.algalog.algalogapi.Controller;

import com.algaworks.algalog.algalogapi.Model.Entrega;
import com.algaworks.algalog.algalogapi.Service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaService entregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(Entrega entrega){
        return entregaService.solicitar(entrega);
    }
}
