package com.ai.algoritmo.service;

import com.ai.algoritmo.algoritmo.BuscaLabirinto;
import com.ai.algoritmo.model.LabirintoRequest;
import org.springframework.stereotype.Service;

@Service
public class LabirintoService {

    private final BuscaLabirinto buscaLabirinto;

    public LabirintoService() {
        this.buscaLabirinto = new BuscaLabirinto();
    }

    public String buscar(LabirintoRequest request) {
        buscaLabirinto.buscaLargura(
                request.getLabirinto(),
                request.getInicio().getLinha(),
                request.getInicio().getColuna(),
                request.getFim().getLinha(),
                request.getFim().getColuna()
        );

        return "Busca realizada pelo Service";
    }
}