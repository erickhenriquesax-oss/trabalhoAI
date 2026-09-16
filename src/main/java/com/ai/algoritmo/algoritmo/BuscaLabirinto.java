package com.ai.algoritmo.algoritmo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuscaLabirinto{

    private static final int[][] DIRECOES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class No {
        int coluna;
        int lado;
        No pai;
        double custo;
        double heuristica;
        double funcao_avaliacao_A;

        public No(int lado, No pai, double custo, double heuristica, int coluna){
            this.lado = lado;
            this.pai = pai;
            this.custo = custo;
            this.funcao_avaliacao_A = heuristica + custo;
            this.heuristica = heuristica;
            this.coluna = coluna;
        }
    }
    public void buscaAEstrela(int[][] labirinto, int inicio, int inicioColuna, int fim, int fimColuna){
        System.out.println("Busca Estrela");
        // Fila ordenada pelo menor valor da função f = custo + heurística
        PriorityQueue<No> filaAberta = new PriorityQueue<>(Comparator.comparingDouble(n -> n.funcao_avaliacao_A));

        boolean[][] visitado = new boolean[labirinto.length][labirinto[0].length];

        double heuristicaInicial = distanciaManhattan(inicio, inicioColuna, fim, fimColuna);

        filaAberta.add(new No(inicio, null, 0, heuristicaInicial, inicioColuna));

        int nosVisitados = 0;

        while(!filaAberta.isEmpty()){
            No atual = filaAberta.poll();

            // Se já foi visitado, ignora
            if (visitado[atual.lado][atual.coluna]){
                continue;
            }
            visitado[atual.lado][atual.coluna] = true;
            nosVisitados++;

            if(atual.lado == fim && atual.coluna == fimColuna){
                System.out.println("Destino alcançado!");
                System.out.println("Nós visitados: " + nosVisitados);
                return;
            }
            for (int[] d : DIRECOES){
                int novoLado = atual.lado + d[0];
                int novaColuna = atual.coluna + d[1];
                if(posicaoValida(labirinto, novoLado, novaColuna) && !visitado[novoLado][novaColuna]){
                    double custo = atual.custo + 1;
                    double heuristica = distanciaManhattan(novoLado, novaColuna, fim, fimColuna);

                    filaAberta.add(new No(novoLado, atual, custo, heuristica, novaColuna));
                }
            }
        }
        System.out.println("Caminho não encontrado!");
    }

    // h(n) = (linha_atual - linha_destino)+ (coluna_atual - coluna_destino)
    static double distanciaManhattan(int l1, int c1, int l2, int c2){
        return Math.abs(l1 - l2) + Math.abs(c1 - c2);
    }

    public void buscaLargura(int[][] labirinto, int inicio, int inicioColuna, int fim, int fimColuna){

        Queue<No> fila = new LinkedList<>();
        boolean[][] visitado = new boolean[labirinto.length][labirinto[0].length];

        fila.add(new No(inicio, null, 0, 0, inicioColuna));
        visitado[inicio][inicioColuna] = true;

        int nosVisitados = 0;

        while(!fila.isEmpty()){
            No atual = fila.poll();
            nosVisitados += 1;

            if(atual.lado == fim && atual.coluna == fimColuna){
                System.out.println("Destino alcançado!");
                return;
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
        System.out.println("Caminho não encontrado!");
    }
    private boolean posicaoValida(int[][] labirinto, int linha, int coluna){
        return linha >= 0 && linha < labirinto.length && coluna >= 0 && coluna < labirinto[0].length && labirinto[linha][coluna] == 1;
    }
}