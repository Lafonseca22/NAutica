/**
 * Representa uma bateria recarregavel, medida em miliampere-hora (mAh).
 *
 * <p>E usada por composicao noutras classes (por exemplo {@link Drone} e
 * {@link RemoteControlledBoat}). Simula ainda o desgaste: a cada carga
 * completa, a capacidade maxima baixa 10%.</p>
 *
 * @author Leonardo Fonseca
 * @version 1.0
 */
public class Battery {

    /** Capacidade maxima atual da bateria, em mAh. */
    private double capacidadeMaxima;

    /** Carga disponivel neste momento, em mAh. */
    private double cargaAtual;

    /**
     * Cria uma bateria sem carga.
     *
     * @param cargaMaxima capacidade maxima inicial, em mAh; se for menor ou
     *                    igual a zero, assume-se 1000 mAh por omissao
     */
    public Battery(double cargaMaxima) {
        if (cargaMaxima <= 0) {
            cargaMaxima = 1000;
        }
        this.capacidadeMaxima = cargaMaxima;
        this.cargaAtual = 0;
    }

    /**
     * Devolve a capacidade maxima atual da bateria.
     *
     * @return a capacidade maxima, em mAh
     */
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     * Devolve a carga disponivel neste momento.
     *
     * @return a carga atual, em mAh
     */
    public double getCargaAtual() {
        return cargaAtual;
    }

    /**
     * Carrega a bateria ate ao maximo.
     *
     * <p>Cada ciclo de carga desgasta a bateria: a capacidade maxima passa a
     * ser 90% do valor anterior.</p>
     */
    public void carregarTotalmente() {
        capacidadeMaxima = capacidadeMaxima * 0.9;   // desgaste de 10%
        cargaAtual = capacidadeMaxima;               // fica cheia
    }

    /**
     * Descarrega completamente a bateria, colocando a carga atual a zero.
     */
    public void descarregarTotalmente() {
        cargaAtual = 0;
    }

    /**
     * Consome carga da bateria.
     *
     * @param quantidade carga a consumir, em mAh; nao pode ser negativa nem
     *                   superior a carga existente
     * @return {@code true} se a utilizacao teve sucesso, {@code false} caso
     *         a quantidade seja invalida
     */
    public boolean useCharge(double quantidade) {
        if (quantidade < 0 || quantidade > cargaAtual) {
            return false;
        }
        cargaAtual = cargaAtual - quantidade;
        return true;
    }

    /**
     * Calcula a percentagem de carga atual.
     *
     * @return a carga atual em percentagem (0 a 100)
     */
    public double getPercentagemCarga() {
        if (capacidadeMaxima == 0) {
            return 0;
        }
        return (cargaAtual / capacidadeMaxima) * 100;
    }
}
