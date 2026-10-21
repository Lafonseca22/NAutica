/*
 * Laboratorio 03.01 - classe Motor (Nivel 4).
 * Representa o motor usado pelo drone e pelo barco.
 */
public class Motor {

    private double consumption;    // consumo por ciclo, em mAh
    private boolean isTurnedOn;    // ligado ou desligado

    // Consumo minimo (e por omissao) de 1 mAh.
    public Motor(double consumption) {
        if (consumption < 1) {
            consumption = 1;
        }
        this.consumption = consumption;
        this.isTurnedOn = false;
    }

    public double getConsumption() {
        return consumption;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        isTurnedOn = true;
    }

    public void turnOff() {
        isTurnedOn = false;
    }
}
