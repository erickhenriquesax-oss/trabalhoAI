package com.ai.algoritmo.algoritmo;

import com.ai.algoritmo.model.Posicao;
import com.ai.algoritmo.model.ResultadoBusca;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuscaLabirinto {

    private static final int[][] DIRECOES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class No {
        int coluna;
        int lado;
        No pai;
        double custo;
        double heuristica;
        double funcao_avaliacao_A;

        public No(int lado, No pai, double custo, double heuristica, int coluna) {
            this.lado = lado;
            this.pai = pai;
            this.custo = custo;
            this.funcao_avaliacao_A = heuristica + custo;
            this.heuristica = heuristica;
            this.coluna = coluna;
        }
    }

    public ResultadoBusca buscaAEstrela(int[][] labirinto, int inicio, int inicioColuna, int fim, int fimColuna){

        long inicioNano = System.nanoTime();
        PriorityQueue<No> filaAberta = new PriorityQueue<>(Comparator.comparingDouble(n -> n.funcao_avaliacao_A));

        boolean[][] visitado = new boolean[labirinto.length][labirinto[0].length];
        double heuristicaInicial = distanciaManhattan(inicio, inicioColuna, fim, fimColuna);

        filaAberta.add(new No(inicio, null, 0, heuristicaInicial, inicioColuna));

        int nosVisitados = 0;

        List<Posicao> ordemVisitacao = new LinkedList<>();

        while (!filaAberta.isEmpty()){

            No atual = filaAberta.poll();

            // Se a posição já foi processada, ignora
            if(visitado[atual.lado][atual.coluna]){
                continue;
            }

            visitado[atual.lado][atual.coluna] = true;

            nosVisitados++;

            ordemVisitacao.add(new Posicao(atual.lado, atual.coluna));

            if (atual.lado == fim && atual.coluna == fimColuna) {

                return montarResultado(true, atual, inicioNano, ordemVisitacao, "A_ESTRELA");
            }

            for (int[] d : DIRECOES) {
                int novoLado = atual.lado + d[0];
                int novaColuna = atual.coluna + d[1];

                if(posicaoValida(labirinto, novoLado, novaColuna) && !visitado[novoLado][novaColuna]){

                    double custo= atual.custo + 1;

                    double heuristica = distanciaManhattan(novoLado, novaColuna, fim, fimColuna);
                    filaAberta.add(new No(novoLado, atual, custo, heuristica, novaColuna));
                }
            }
        }
        return montarResultado(false, null, inicioNano, ordemVisitacao, "A_ESTRELA");
    }
    static double distanciaManhattan(int l1, int c1, int l2, int c2){
        return Math.abs(l1 - l2) +Math.abs(c1 - c2);
    }

    public ResultadoBusca buscaLargura(
            int[][] labirinto,
            int inicio,
            int inicioColuna,
            int fim,
            int fimColuna
    ){

        long inicioNano = System.nanoTime();

        Queue<No> fila = new LinkedList<>();

        boolean[][] visitado = new boolean[labirinto.length][labirinto[0].length];
        fila.add(new No(inicio, null, 0, 0, inicioColuna));

        visitado[inicio][inicioColuna] = true;
        int nosVisitados = 0;

        List<Posicao> ordemVisitacao = new LinkedList<>();

        while (!fila.isEmpty()){

            No atual = fila.poll();
            nosVisitados++;

            ordemVisitacao.add(new Posicao(atual.lado, atual.coluna));

            if (atual.lado == fim && atual.coluna == fimColuna){
                return montarResultado(true, atual, inicioNano, ordemVisitacao, "BFS");
            }

            for(int[] d : DIRECOES){
                int novaLinha = atual.lado + d[0];
                int novaColuna = atual.coluna + d[1];

                if(posicaoValida(labirinto, novaLinha, novaColuna) && !visitado[novaLinha][novaColuna]){

                    visitado[novaLinha][novaColuna] = true;
                    fila.add(new No(novaLinha, atual, atual.custo + 1, 0, novaColuna));
                }
            }
        }
        return montarResultado(false, null, inicioNano, ordemVisitacao, "BFS");
    }
    private boolean posicaoValida(int[][] labirinto, int linha, int coluna){
        return linha >= 0 && linha < labirinto.length && coluna >= 0 && coluna < labirinto[0].length && labirinto[linha][coluna] == 1;
    }
    private List<Posicao> reconstruirCaminho(No no){
        LinkedList<Posicao> caminho = new LinkedList<>();
        No atual = no;
        while (atual != null) {
            caminho.addFirst(new Posicao(atual.lado, atual.coluna));
            atual = atual.pai;
        }
        return caminho;
    }
    private ResultadoBusca montarResultado(boolean encontrado, No noFinal, long inicioNano, List<Posicao> ordemVisitacao, String nomeAlgoritmo){
        long duracaoNano = System.nanoTime() - inicioNano;

        List<Posicao> caminho = encontrado ? reconstruirCaminho(noFinal) : Collections.emptyList();

        return new ResultadoBusca(encontrado, nomeAlgoritmo, ordemVisitacao.size(), caminho, ordemVisitacao, duracaoNano
        );
    }
}