package com.ai.algoritmo.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LabirintoRequest {
    private int[][] labirinto;
    private Posicao inicio;
    private Posicao fim;
    private String algoritmo;
}
