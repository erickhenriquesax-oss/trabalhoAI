package com.ai.algoritmo.controller;


import com.ai.algoritmo.model.LabirintoRequest;
import com.ai.algoritmo.model.ResultadoBusca;
import com.ai.algoritmo.service.LabirintoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/labirinto")
public class LabirintoController {

    private final LabirintoService service;

    public LabirintoController(LabirintoService service) {
        this.service = service;
    }

    @PostMapping("/buscar")
    public ResultadoBusca buscar(@RequestBody LabirintoRequest request) {

        return service.buscar(request);
    }
}
