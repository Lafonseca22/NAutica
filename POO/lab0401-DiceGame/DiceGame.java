/*
 * Laboratorio 04.01 - Scanner, Random e Ciclos de Repeticao
 *
 * Jogo de dados: o jogador define um maximo; lanca o dado (1 a 6) somando
 * pontos. Se igualar o maximo, ganha; se ultrapassar, perde.
 * Reune os Niveis 3, 4 e 5 do enunciado.
 */
import java.util.Random;

public class DiceGame {

    private static final int MAXIMO_POR_OMISSAO = 6;

    private int numeroMaximo;       // limite a atingir
    private int numeroTentativas;   // lancamentos efetuados
    private int pontuacaoAtual;     // soma dos pontos
    private boolean jogoTerminado;  // o jogo acabou?
    private InputReader leitor;     // leitura do teclado
    private Random random;          // gerador de numeros aleatorios

    public DiceGame() {
        numeroMaximo = MAXIMO_POR_OMISSAO;
        numeroTentativas = 0;
        pontuacaoAtual = 0;
        jogoTerminado = false;
        leitor = new InputReader();
        random = new Random();
    }

    // Nivel 3: devolve um numero aleatorio entre 1 e 6.
    public int rollDice() {
        return random.nextInt(6) + 1;
    }

    // Nivel 4: mostra o cabecalho e o estado do jogo.
    public void showPlay() {
        System.out.println("+---------------------+");
        System.out.println("|    JOGO DE DADOS     |");
        System.out.println("+---------------------+");
        System.out.println("Valor maximo    :" + numeroMaximo);
        System.out.println("N de tentativas :" + numeroTentativas);
        System.out.println("Pontuacao atual :" + pontuacaoAtual);
    }

    // Nivel 4: pede o numero maximo, validando-o.
    public void inputMaximumNumber() {
        int valor = leitor.getIntegerNumber("Indique o numero maximo a atingir");
        while (valor < 0) {
            System.out.println("Valor invalido: nao pode ser negativo.");
            valor = leitor.getIntegerNumber("Indique o numero maximo a atingir");
        }
        if (valor == 0) {
            numeroMaximo = MAXIMO_POR_OMISSAO;
            System.out.println("Valor zero: assumido o maximo por omissao (" + MAXIMO_POR_OMISSAO + ").");
        } else {
            numeroMaximo = valor;
        }
    }

    // Nivel 5: ciclo principal do jogo.
    public void play() {
        char novoJogo;
        do {
            // Reiniciar o estado para um jogo novo.
            numeroTentativas = 0;
            pontuacaoAtual = 0;
            jogoTerminado = false;

            inputMaximumNumber();
            showPlay();

            // Recebe comandos ate o jogo terminar.
            while (!jogoTerminado) {
                String comando = leitor.getText("Comando (JOGAR/SAIR)").trim().toUpperCase();

                if (comando.equals("JOGAR")) {
                    int valorDado = rollDice();
                    numeroTentativas++;
                    pontuacaoAtual += valorDado;
                    System.out.println("Saiu no dado: " + valorDado);
                    showPlay();

                    if (pontuacaoAtual == numeroMaximo) {
                        System.out.println(">> GANHOU! Atingiu exatamente " + numeroMaximo + ".");
                        jogoTerminado = true;
                    } else if (pontuacaoAtual > numeroMaximo) {
                        System.out.println(">> PERDEU! Ultrapassou " + numeroMaximo + ".");
                        jogoTerminado = true;
                    }
                } else if (comando.equals("SAIR")) {
                    System.out.println("A terminar o jogo...");
                    return;   // sai do play() por completo
                } else {
                    System.out.println("Comando invalido. Use JOGAR ou SAIR.");
                }
            }

            // Jogo terminou: perguntar se quer outro.
            novoJogo = leitor.getCharacter("Novo jogo? (S/N)");
            novoJogo = Character.toUpperCase(novoJogo);

        } while (novoJogo == 'S');

        System.out.println("Obrigado por jogar!");
    }
}
