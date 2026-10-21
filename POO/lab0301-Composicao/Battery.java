/*
 * Laboratorio 03.01 - Composicao de Classes
 *
 * Classe Battery: bateria recarregavel medida em mAh.
 * Reune Nivel 1 e 2 (validacoes + desgaste de 10% por carga).
 */
public class Battery {

    private double capacidadeMaxima;   // capacidade maxima atual, em mAh
    private double cargaAtual;         // carga atual, em mAh

    // Construtor: bateria sem carga. Se a capacidade for <= 0, assume 1000 mAh.
    public Battery(double cargaMaxima) {
        if (cargaMaxima <= 0) {
            cargaMaxima = 1000;
        }
        this.capacidadeMaxima = cargaMaxima;
        this.cargaAtual = 0;
    }

    // ---------------- Seletores ----------------
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public double getCargaAtual() {
        return cargaAtual;
    }

    // ---------------- Comportamento ----------------
    // Carrega ao maximo. Cada ciclo de carga desgasta 10% a capacidade maxima.
    public void carregarTotalmente() {
        capacidadeMaxima = capacidadeMaxima * 0.9;   // desgaste: fica a 90%
        cargaAtual = capacidadeMaxima;               // fica cheia (ate ao novo maximo)
    }

    public void descarregarTotalmente() {
        cargaAtual = 0;
    }

    // Usa carga. Rejeita valores negativos ou acima da carga existente.
    // Devolve true se a utilizacao teve sucesso.
    public boolean useCharge(double quantidade) {
        if (quantidade < 0 || quantidade > cargaAtual) {
            return false;
        }
        cargaAtual = cargaAtual - quantidade;
        return true;
    }

    // Percentagem de carga (0 a 100).
    public double getPercentagemCarga() {
        if (capacidadeMaxima == 0) {
            return 0;
        }
        return (cargaAtual / capacidadeMaxima) * 100;
    }
}
