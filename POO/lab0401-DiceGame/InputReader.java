/*
 * Laboratorio 04.01 - classe InputReader fornecida no enunciado.
 * Nivel 1: codigo base.  Nivel 2: metodo getCharacter implementado.
 *
 * Centraliza a leitura do teclado (Scanner) num so sitio.
 */
import java.util.Scanner;

public class InputReader {

    private Scanner reader;

    public InputReader() {
        reader = new Scanner(System.in);
    }

    // Le um inteiro, insistindo enquanto o utilizador nao escrever um numero.
    public int getIntegerNumber(String question) {
        showFormattedQuestion(question);
        while (!reader.hasNextInt()) {
            reader.nextLine();
            showFormattedQuestion(question);
        }
        int number = reader.nextInt();
        reader.nextLine();
        return number;
    }

    // Le uma linha de texto.
    public String getText(String question) {
        showFormattedQuestion(question);
        return reader.nextLine();
    }

    // Nivel 2: le um caracter. Se o texto for vazio, devolve um espaco.
    public char getCharacter(String question) {
        String text = getText(question);
        if (text.isEmpty()) {
            return ' ';
        }
        return text.charAt(0);
    }

    private void showFormattedQuestion(String question) {
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);
    }
}
