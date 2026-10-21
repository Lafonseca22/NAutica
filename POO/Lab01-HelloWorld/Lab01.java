/*
 * Laboratorio 01.01 - Bytecode, JVM, NetBeans e "Hello World"
 *
 * Objetivo: primeiro programa em Java (aplicacao de consola).
 * Regras: PascalCase nas classes, camelCase em metodos/variaveis,
 *         substantivos nas variaveis, verbos nos metodos.
 *
 * Reune os Niveis 2, 3 e 4 do enunciado.
 */
public class Lab01 {

    public static void main(String[] args) {

        // --- Nivel 2 e 3: escrever a frase identificando o autor ---
        // 'autor' e um substantivo (variavel) inicializado no programa.
        String autor = "Leonardo Fonseca";
        System.out.println("\"Este e um programa em Java.\" (" + autor + ")");

        // --- Nivel 4: somar os numeros inteiros impares de 0 a 99 ---
        // Percorremos 0..99 e somamos so os que tem resto 1 na divisao por 2.
        int soma = 0;
        for (int numero = 0; numero <= 99; numero++) {
            if (numero % 2 != 0) {      // numero impar
                soma = soma + numero;
            }
        }
        System.out.println("Soma dos impares de 0 a 99: " + soma);   // 2500
    }
}
