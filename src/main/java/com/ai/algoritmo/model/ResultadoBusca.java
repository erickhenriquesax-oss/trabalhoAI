package com.ai.algoritmo.model;

import java.util.List;

public class ResultadoBusca {

    private boolean encontrado;
    private String algoritmo;
    private int nosVisitados;
    private List<Posicao> caminho;
    private List<Posicao> ordemVisitacao;
    private long tempoExecucaoNanos;

    public ResultadoBusca(
            boolean encontrado,
            String algoritmo,
            int nosVisitados,
            List<Posicao> caminho,
            List<Posicao> ordemVisitacao,
            long tempoExecucaoNanos
    ) {
        this.encontrado = encontrado;
        this.algoritmo = algoritmo;
        this.nosVisitados = nosVisitados;
        this.caminho = caminho;
        this.ordemVisitacao = ordemVisitacao;
        this.tempoExecucaoNanos = tempoExecucaoNanos;
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public int getNosVisitados() {
        return nosVisitados;
    }

    public List<Posicao> getCaminho() {
        return caminho;
    }

    public List<Posicao> getOrdemVisitacao() {
        return ordemVisitacao;
    }

    public long getTempoExecucaoNanos() {
        return tempoExecucaoNanos;
    }
}