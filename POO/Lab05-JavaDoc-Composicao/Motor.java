/**
 * Representa o motor usado pelo {@link Drone} e pelo
 * {@link RemoteControlledBoat}.
 *
 * <p>Tem um consumo por ciclo e um estado ligado/desligado.</p>
 *
 * @author Leonardo Fonseca
 * @version 1.0
 */
public class Motor {

    /** Consumo do motor por ciclo, em mAh. */
    private double consumption;

    /** Indica se o motor esta ligado ({@code true}) ou desligado. */
    private boolean isTurnedOn;

    /**
     * Cria um motor desligado.
     *
     * @param consumption consumo por ciclo, em mAh; o minimo (e valor por
     *                    omissao) e 1 mAh
     */
    public Motor(double consumption) {
        if (consumption < 1) {
            consumption = 1;
        }
        this.consumption = consumption;
        this.isTurnedOn = false;
    }

    /**
     * Devolve o consumo do motor por ciclo.
     *
     * @return o consumo, em mAh
     */
    public double getConsumption() {
        return consumption;
    }

    /**
     * Indica se o motor esta ligado.
     *
     * @return {@code true} se estiver ligado, {@code false} caso contrario
     */
    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    /** Liga o motor. */
    public void turnOn() {
        isTurnedOn = true;
    }

    /** Desliga o motor. */
    public void turnOff() {
        isTurnedOn = false;
    }
}
