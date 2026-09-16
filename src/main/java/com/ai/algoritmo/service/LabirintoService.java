package com.ai.algoritmo.service;

import com.ai.algoritmo.algoritmo.BuscaLabirinto;
import com.ai.algoritmo.model.LabirintoRequest;
import com.ai.algoritmo.model.ResultadoBusca;
import org.springframework.stereotype.Service;

@Service
public class LabirintoService {

    private final BuscaLabirinto buscaLabirinto;

    public LabirintoService() {
        this.buscaLabirinto = new BuscaLabirinto();
    }

    public ResultadoBusca buscar(LabirintoRequest request) {
        if(request.getAlgoritmo().equals("BFS")){
            return buscaLabirinto.buscaLargura(
                    request.getLabirinto(),
                    request.getInicio().getLinha(),
                    request.getInicio().getColuna(),
                    request.getFim().getLinha(),
                    request.getFim().getColuna()
            );
        }
        if(request.getAlgoritmo().equals("A_ESTRELA")){
            return buscaLabirinto.buscaAEstrela(
                    request.getLabirinto(),
                    request.getInicio().getLinha(),
                    request.getInicio().getColuna(),
                    request.getFim().getLinha(),
                    request.getFim().getColuna()
            );
        }
        return null;
    }
}