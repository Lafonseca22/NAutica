# POO — Programação Orientada a Objetos (Java)

Resoluções dos laboratórios da cadeira, em Java. Cada pasta é um laboratório
independente, com código **comentado** e **testado** (compila e corre em Java 21).

> ⚠️ **Usa isto para aprender, não para entregar às cegas.** A cadeira tem
> **discussão/prova oral** do projeto (obrigatória, nota mínima 10). Se não
> perceberes o código, não defendes. Lê, reescreve à tua maneira, e usa estas
> soluções como gabarito para comparar.

---

## Como funciona a cadeira

- **Linguagem:** Java. **IDE de referência:** NetBeans (precisas do JDK instalado).
- **O que se aprende:** o paradigma de objetos — em vez de um programa ser uma
  lista de instruções (imperativo), modela-se o mundo em **classes** (moldes) que
  produzem **objetos** (coisas com *estado* e *comportamento*). Ao longo do
  semestre: classes e objetos → encapsulamento → composição → herança →
  polimorfismo → exceções → ficheiros → testes unitários.
- **Avaliação:** 2 testes (mín. 8, média 9.5) + **Projeto + Discussão** (mín. 10,
  obrigatório) + Desempenho. Nota final = `0.5×testes + 0.3×projeto + 0.2×desempenho`.
- **Regras de código do professor** (segue sempre):
  - `PascalCase` nas classes (ex.: `TravelCard`), `camelCase` em métodos e
    variáveis (ex.: `getTripPrice`, `saldo`).
  - **Verbos** nos métodos (`imprimirDocumento`), **substantivos** nas variáveis (`autor`).
  - Nos labs iniciais, **não ler do teclado** — usar variáveis já inicializadas.

---

## Os conceitos-chave (o vocabulário da oral)

| Conceito | Em 1 frase | Onde está |
|----------|-----------|-----------|
| **Classe** | o molde / a planta da casa | `Impressora`, `TravelCard`, `Battery` |
| **Objeto** | uma casa construída a partir da planta | `new Impressora(...)` |
| **Atributo** | o *estado* do objeto (as suas variáveis) | `saldo`, `cargaAtual` |
| **Método** | o *comportamento* (o que o objeto sabe fazer) | `beginTrip()`, `fly()` |
| **Construtor** | o método que "nasce" o objeto e inicializa o estado | `public TravelCard()` |
| **Encapsulamento** | atributos `private` + `getters` para proteger o estado | em todas as classes |
| **Enumeração** | um tipo com um conjunto fechado de valores | `TipoMarcaTinteiro` |
| **Composição** | um objeto **tem** outros objetos lá dentro | `Drone` tem `Battery` + `Motor` |

---

## Os laboratórios

### `Lab01-HelloWorld` — Lab 01.01
Primeiro programa. Escreve uma frase identificando o autor e soma os ímpares de
0 a 99. Ensina: criar projeto, `main`, variáveis, `System.out.println`, ciclo `for`.
**Correr:** `Lab01`.

### `Lab0102-RevisaoCJava` — Lab 01.02
Revisão de fundamentos, tudo dentro do `main`: ordenar 3 inteiros, arrays e ciclos,
converter horas/minutos/segundos, procurar num array de `double` com um `boolean`,
e partir uma string com `.split()`. Ensina: tipos, arrays, `printf`, condições.
**Correr:** `Programa`.

### `lab0201-Impressora` — Lab 02.01
Primeira **classe** a sério: uma `Impressora` que regista impressões e gere a tinta,
com uma **enumeração** para a marca do tinteiro. Ensina: atributos, construtor,
getters, métodos que alteram o estado.
**Correr:** `Lab0201`.

### `lab0202-TravelCard` — Lab 02.02
Um cartão de transportes com muitas **validações** (`if`). Carregar, iniciar/terminar
viagem, ver viagens disponíveis, recarregar e descontos por fidelidade. Ensina:
instruções de seleção, reutilização de métodos, estados do objeto.
**Correr:** `Lab0202`.

### `lab0301-Composicao` — Lab 03.01
**Composição**: um `Drone` e um `RemoteControlledBoat`, ambos feitos de uma
`Battery` e um `Motor`. Ensina: objetos dentro de objetos, delegar trabalho
(o drone pede à bateria `useCharge`), simular desgaste.
**Correr:** `Lab0301`.

### `lab0401-DiceGame` — Lab 04.01
Jogo de dados interativo. Usa a classe `InputReader` (teclado), `Random` e **ciclos**
(`do/while`). Ensina: ler do teclado, aleatoriedade, repetição até uma condição.
**Correr:** `Lab0401` — **interativo**, tens de escrever no teclado (`JOGAR` / `SAIR`).

---

## Como abrir e correr no NetBeans

Cada lab aqui são ficheiros `.java` soltos. Para os pores no NetBeans:

1. **File → New Project → Java with Ant → Java Application**, dá o nome do lab
   (ex.: `Lab01`). Desmarca "Create Main Class" ou deixa e substitui depois.
2. Arrasta/copia os `.java` da pasta para dentro do *Source Packages* do projeto.
3. **Botão direito no projeto → Run** (ou F6). A classe a correr é a que tem `main`
   (a que começa por `Lab...`).

**Alternativa rápida (terminal, sem NetBeans):**
```bash
cd lab0301-Composicao
javac -encoding UTF-8 *.java
java Lab0301
```

---

## Nota sobre a pergunta final do TravelCard

O enunciado pergunta: *"para mostrar o valor total dos descontos obtidos, que
alterações fazer?"* — Resposta: adicionar um atributo `descontosAcumulados`
(`double`), somar-lhe o desconto em cada `beginTrip` (`preço × getDiscount()`), e
criar um getter/linha no `showInfo` para o mostrar. Não está implementado no código
de propósito — é um bom exercício para fazeres tu e perceberes o fluxo.
