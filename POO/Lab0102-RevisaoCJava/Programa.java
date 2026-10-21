/*
 * Laboratorio 01.02 - Revisao de C e Introducao ao Java
 *
 * Todo o codigo fica dentro do main (como pede o enunciado).
 * Cada Nivel esta separado por comentarios.
 */
import java.util.Arrays;

public class Programa {

    public static void main(String[] args) {

        // ===================== Nivel 1 =====================
        // Tres inteiros, escritos por ordem crescente.
        int a = 5, b = 1, c = 3;
        int[] ordenados = { a, b, c };
        Arrays.sort(ordenados);          // ordena por ordem crescente
        System.out.print("Nivel 1 - valores por ordem crescente: ");
        for (int i = 0; i < ordenados.length; i++) {
            System.out.print(ordenados[i]);
            if (i < ordenados.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // ===================== Nivel 2 =====================
        // Array de 10 inteiros preenchido com 0..9 e escrito com um ciclo.
        int[] valores = new int[10];         // forma correta em Java
        for (int i = 0; i < valores.length; i++) {
            valores[i] = i;
        }
        System.out.print("Nivel 2 - array 0..9: ");
        for (int valor : valores) {           // ciclo for-each
            System.out.print(valor + " ");
        }
        System.out.println();

        // ===================== Nivel 3 =====================
        // Tempo de uma tarefa (h, m, s) + segundos extra. Max de m e s = 59.
        int horas = 1, minutos = 30, segundos = 45;
        int segundosAdicionais = 3725;        // valor entre 500 e 10000

        System.out.printf("Nivel 3 - antes:  %02d:%02d:%02d%n", horas, minutos, segundos);

        // Abordagem: converter tudo para segundos, somar, voltar a converter.
        int totalSegundos = horas * 3600 + minutos * 60 + segundos + segundosAdicionais;
        horas = totalSegundos / 3600;
        int resto = totalSegundos % 3600;
        minutos = resto / 60;
        segundos = resto % 60;
        System.out.printf("Nivel 3 - depois: %02d:%02d:%02d%n", horas, minutos, segundos);

        // ===================== Nivel 4 =====================
        // Procurar um valor num array de reais (double).
        double[] reais = { 1.5, 2.0, 3.25, 4.1, 5.9, 6.0, 7.7, 8.3, 9.9, 10.0 };
        double findNumber = 5.9;
        boolean isFound = false;
        for (double real : reais) {
            if (real == findNumber) {
                isFound = true;
            }
        }
        System.out.print("Nivel 4 - array: " + Arrays.toString(reais));
        System.out.println(" | a procurar: " + findNumber
                + " -> " + (isFound ? "encontrado" : "nao encontrado"));

        // ===================== Nivel 5 =====================
        // Decompor "Jonas Pistolas" em nome e apelido com split.
        String nomeCompleto = "Jonas Pistolas";
        String[] partes = nomeCompleto.split(" ");
        System.out.println("Nivel 5 - Nome: " + partes[0]);
        System.out.println("Nivel 5 - Apelido: " + partes[1]);
    }
}
