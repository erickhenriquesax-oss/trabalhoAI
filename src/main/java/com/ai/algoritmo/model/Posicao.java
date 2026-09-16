package com.ai.algoritmo.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Posicao {
    private int coluna;
    private int linha;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
}
