# API de Busca em Labirintos

API REST desenvolvida em Java + Spring Boot para execução de algoritmos de busca em labirintos.

- BFS (Busca em Largura)
- A* (A-Estrela)

Isso para o Trabalho de IA, Veja se vai dar boa João

A API recebe uma matriz representando o labirinto e retorna:
- se existe caminho;
- algoritmo utilizado;
- quantidade de nós visitados;
- caminho encontrado;
- ordem de visitação;
- tempo de execução.

## Tecnologias

- Java
- Spring Boot
- Maven
- REST API

## Como funciona a matriz

A matriz utiliza:

- `1` → posição livre
- `0` → parede/bloqueio

Exemplo:

```json
[
  [1, 0, 0, 0, 0],
  [1, 1, 1, 0, 1],
  [0, 0, 1, 0, 1],
  [0, 1, 1, 1, 1],
  [0, 0, 0, 0, 1]
]

{
  "labirinto": [
    [1, 0, 0, 0, 0],
    [1, 1, 1, 0, 1],
    [0, 0, 1, 0, 1],
    [0, 1, 1, 1, 1],
    [0, 0, 0, 0, 1]
  ],
  "inicio": {
    "linha": 0,
    "coluna": 0
  },
  "fim": {
    "linha": 4,
    "coluna": 4
  },
  "algoritmo": "A_ESTRELA"
}
RESULTADO
{
  "encontrado": true,
  "algoritmo": "A_ESTRELA",
  "nosVisitados": 9,
  "caminho": [
    {
      "linha": 0,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 1
    },
    {
      "linha": 1,
      "coluna": 2
    },
    {
      "linha": 2,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 3
    },
    {
      "linha": 3,
      "coluna": 4
    },
    {
      "linha": 4,
      "coluna": 4
    }
  ],
  "ordemVisitacao": [
    {
      "linha": 0,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 1
    },
    {
      "linha": 1,
      "coluna": 2
    },
    {
      "linha": 2,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 3
    },
    {
      "linha": 3,
      "coluna": 4
    },
    {
      "linha": 4,
      "coluna": 4
    }
  ],
  "tempoExecucaoNanos": 3724900
}
BFS: {
  "labirinto": [
    [1, 0, 0, 0, 0],
    [1, 1, 1, 0, 1],
    [0, 0, 1, 0, 1],
    [0, 1, 1, 1, 1],
    [0, 0, 0, 0, 1]
  ],
  "inicio": {
    "linha": 0,
    "coluna": 0
  },
  "fim": {
    "linha": 4,
    "coluna": 4
  },
  "algoritmo": "BFS"
}
RESULTADO:
{
  "encontrado": true,
  "algoritmo": "BFS",
  "nosVisitados": 11,
  "caminho": [
    {
      "linha": 0,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 1
    },
    {
      "linha": 1,
      "coluna": 2
    },
    {
      "linha": 2,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 3
    },
    {
      "linha": 3,
      "coluna": 4
    },
    {
      "linha": 4,
      "coluna": 4
    }
  ],
  "ordemVisitacao": [
    {
      "linha": 0,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 0
    },
    {
      "linha": 1,
      "coluna": 1
    },
    {
      "linha": 1,
      "coluna": 2
    },
    {
      "linha": 2,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 2
    },
    {
      "linha": 3,
      "coluna": 1
    },
    {
      "linha": 3,
      "coluna": 3
    },
    {
      "linha": 3,
      "coluna": 4
    },
    {
      "linha": 2,
      "coluna": 4
    },
    {
      "linha": 4,
      "coluna": 4
    }
  ],
  "tempoExecucaoNanos": 1383200
}
