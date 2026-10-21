/*
 * Laboratorio 02.01 - classe com o main que testa a Impressora.
 */
public class Lab0201 {

    public static void main(String[] args) {

        // Nivel 2: criar uma impressora e imprimir dois documentos.
        Impressora impressora = new Impressora(100000, TipoMarcaTinteiro.HP);

        impressora.imprimirDocumento("Leonardo Fonseca - documento 1");
        impressora.imprimirDocumento("Leonardo Fonseca - documento 2");

        System.out.println("Impressoes do tinteiro: " + impressora.getImpressoesTinteiro());
        System.out.println("Capacidade restante   : " + impressora.getCapacidadeTinteiro());
        System.out.println();

        // Nivel 3: substituir o tinteiro e imprimir mais.
        impressora.substituirTinteiro(5.0);
        impressora.imprimirDocumento("Documento depois de trocar tinteiro");
        System.out.println("Tinteiros utilizados: " + impressora.getTinteirosUtilizados());
        System.out.println("Total de impressoes : " + impressora.getTotalImpressoes());
        System.out.println();

        // Nivel 4 e 5: pagina de teste (mostra tudo e conta como impressao).
        impressora.imprimirPaginaTeste();
    }
}
