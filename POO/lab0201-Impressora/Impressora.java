/*
 * Laboratorio 02.01 - Definicao de Classes + Enumeracao
 *
 * Classe Impressora: regista impressoes e gere os niveis de tinta.
 * Reune os Niveis 1 a 5 do enunciado.
 */
public class Impressora {

    // ---------------- Atributos (estado do objeto) ----------------
    private TipoMarcaTinteiro marcaDoTinteiro;   // marca do tinteiro
    private double capacidadeTinteiro;           // capacidade atual, em mililitros
    private int impressoesTinteiro;              // impressoes com o tinteiro atual
    private int maximoImpressoes;                // maximo durante a vida util
    private int tinteirosUtilizados;             // total de tinteiros ja usados (Nivel 3)
    private int totalImpressoes;                 // total de impressoes da impressora (Nivel 3)

    // ---------------- Construtor ----------------
    // Recebe o maximo de impressoes e a marca. O tinteiro e sempre novo (5 ml).
    public Impressora(int maximoImpressoes, TipoMarcaTinteiro marcaDoTinteiro) {
        this.maximoImpressoes = maximoImpressoes;
        this.marcaDoTinteiro = marcaDoTinteiro;
        this.capacidadeTinteiro = 5.0;      // tinteiro novo de 5 ml
        this.impressoesTinteiro = 0;
        this.tinteirosUtilizados = 1;       // ja entra com um tinteiro colocado
        this.totalImpressoes = 0;
    }

    // ---------------- Seletores (getters) ----------------
    public double getCapacidadeTinteiro() {
        return capacidadeTinteiro;
    }

    public int getImpressoesTinteiro() {
        return impressoesTinteiro;
    }

    public int getMaximoImpressoes() {
        return maximoImpressoes;
    }

    public int getTinteirosUtilizados() {
        return tinteirosUtilizados;
    }

    public int getTotalImpressoes() {
        return totalImpressoes;
    }

    public TipoMarcaTinteiro getMarcaDoTinteiro() {
        return marcaDoTinteiro;
    }

    // ---------------- Comportamento ----------------
    // Simula a impressao de um documento.
    public void imprimirDocumento(String texto) {
        System.out.println(">> A imprimir: " + texto);
        impressoesTinteiro++;
        totalImpressoes++;
        capacidadeTinteiro = capacidadeTinteiro - 0.005;   // gasta tinta
    }

    // Simula a substituicao do tinteiro por um novo (Nivel 3).
    public void substituirTinteiro(double novaCapacidade) {
        impressoesTinteiro = 0;            // contador a zero
        tinteirosUtilizados++;             // mais um tinteiro usado
        capacidadeTinteiro = novaCapacidade;
    }

    // Media de documentos impressos por tinteiro (Nivel 4).
    public double getMediaDocumentosPorTinteiro() {
        if (tinteirosUtilizados == 0) {
            return 0;
        }
        return (double) totalImpressoes / tinteirosUtilizados;
    }

    // Estimativa de impressoes ainda disponiveis (Nivel 4).
    public int getImpressoesDisponiveis() {
        return maximoImpressoes - totalImpressoes;
    }

    // Pagina de teste: mostra todos os atributos. Tambem conta como impressao (Nivel 5).
    public void imprimirPaginaTeste() {
        System.out.println("----- PAGINA DE TESTE -----");
        System.out.println("Marca do tinteiro      : " + marcaDoTinteiro);
        System.out.println("Capacidade (ml)        : " + capacidadeTinteiro);
        System.out.println("Impressoes do tinteiro : " + impressoesTinteiro);
        System.out.println("Maximo de impressoes   : " + maximoImpressoes);
        System.out.println("Tinteiros utilizados   : " + tinteirosUtilizados);
        System.out.println("Total de impressoes    : " + totalImpressoes);
        System.out.println("Media docs/tinteiro    : " + getMediaDocumentosPorTinteiro());
        System.out.println("Impressoes disponiveis : " + getImpressoesDisponiveis());
        System.out.println("---------------------------");

        // Sendo tambem uma impressao, contabiliza.
        impressoesTinteiro++;
        totalImpressoes++;
        capacidadeTinteiro = capacidadeTinteiro - 0.005;
    }
}
