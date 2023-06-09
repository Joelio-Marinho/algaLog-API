package com.algaworks.algalog.algalogapi.Controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problema {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campo;

    @Getter
    @AllArgsConstructor
    public static class Campo{
        private String nome;
        private String mensagem;
    }

}
