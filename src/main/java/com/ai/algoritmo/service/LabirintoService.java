package com.ai.algoritmo.service;


import com.ai.algoritmo.model.LabirintoRequest;
import org.springframework.stereotype.Service;

@Service
public class LabirintoService {
    public String buscar(LabirintoRequest request) {
        System.out.println("Service recebeu:");
        System.out.println("Algoritmo: " + request.getAlgoritmo());

        return "Busca realizada pelo Service";
    }
}
