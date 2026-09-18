const container = document.getElementById("labirinto");

const inicio = { linha: 0, coluna: 0 };
const fim = { linha: 29, coluna: 29 };

//"linkando" os botoes
const btnBfs = document.getElementById("btnBfs");
const btnAstar = document.getElementById("btnAstar");

const celulas = [];


//setando a matriz
const labirinto = [
    [1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
    [1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0],
    [0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,0],
    [0,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,0],
    [0,0,1,1,0,1,0,1,0,0,0,1,1,1,0,1,1,1,0,1,0,1,0,1,0,0,0,0,0,0],
    [0,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,0],
    [0,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,0],
    [0,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0],
    [0,1,0,0,1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,1,1,1,0,1,0,1,1,1,0,0],
    [0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,0],
    [0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,1,1,1,0,0,0,1,0,1,0,1,1,0,0,0],
    [0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,0],
    [0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,1,1,0,0,1,1,0,0],
    [0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0],
    [0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0],
    [0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,0],
    [0,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,1,0,0,0,0],
    [0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0],
    [0,1,0,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1,1,0,0],
    [0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,0],
    [0,1,0,0,0,0,0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,1,0,1,0,0,0,1,0,0],
    [0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0],
    [0,1,0,0,0,1,0,0,0,1,0,1,0,0,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,0],
    [0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0],
    [0,1,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0],
    [0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0],
    [0,1,0,1,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,0],
    [0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1],
];

container.style.gridTemplateColumns = `repeat(${labirinto[0].length}, 40px)`;

for (let l = 0; l < labirinto.length; l++) {
    celulas.push([]);
    for (let c = 0; c < labirinto[0].length; c++) {

        const celula = document.createElement("div");
        celula.className = "celula";
        container.appendChild(celula);

        if (l === inicio.linha && c === inicio.coluna) {
            celula.classList.add("inicio");
        } else if (l === fim.linha && c === fim.coluna) {
            celula.classList.add("fim");
        } else if (labirinto[l][c] === 1) {
            celula.classList.add("livre");
        } else {
            celula.classList.add("parede");
        }

        celulas[l].push(celula);
    }
}

function esperar(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function buscarCaminho(algoritmo) {
    const resposta = await fetch("http://localhost:8080/labirinto/buscar", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            labirinto: labirinto,
            inicio: inicio,
            fim: fim,
            algoritmo: algoritmo
        })
    });
    //envia a requisição do tipo de algoritmo de busca

    const dados = await resposta.json();
    console.log(dados);

    for (const pos of dados.ordemVisitacao) {
        celulas[pos.linha][pos.coluna].classList.add("visitado");
        await esperar(10);
    }

    for (const pos of dados.caminho) {
        celulas[pos.linha][pos.coluna].classList.add("caminho");
        await esperar(10);
    }

    console.log("terminou de pintar");
}

btnBfs.addEventListener("click", function () {
    buscarCaminho("BFS");
});
//seta que ao clicar no botao, bfs ou a* manda uma requisição para a api e a api devolve com o algoritmo selecionado
btnAstar.addEventListener("click", function () {
    buscarCaminho("A_ESTRELA");
});