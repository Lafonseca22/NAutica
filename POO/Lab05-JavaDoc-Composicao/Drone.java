/**
 * Representa um drone, composto por uma {@link Battery} e um {@link Motor}.
 *
 * <p>Exemplo de composicao: o drone <em>tem uma</em> bateria e <em>tem um</em>
 * motor, e delega-lhes trabalho (por exemplo, pede carga a bateria para voar).</p>
 *
 * @author Leonardo Fonseca
 * @version 1.0
 */
public class Drone {

    /** Indica se o drone esta ligado ({@code true}) ou desligado. */
    private boolean isTurnedOn;

    /** A bateria do drone. */
    private Battery battery;

    /** O motor do drone. */
    private Motor motor;

    /**
     * Cria um drone desligado, com uma bateria nova de 1000 mAh e um motor
     * com consumo de 100 mAh.
     */
    public Drone() {
        this.isTurnedOn = false;
        this.battery = new Battery(1000);
        this.motor = new Motor(100);
    }

    /**
     * Cria um drone desligado, com uma bateria nova de 1000 mAh e um motor
     * com o consumo indicado.
     *
     * @param consumoMotor consumo do motor para um ciclo de voo, em mAh
     */
    public Drone(double consumoMotor) {
        this.isTurnedOn = false;
        this.battery = new Battery(1000);
        this.motor = new Motor(consumoMotor);
    }

    /**
     * Indica se o drone esta ligado.
     *
     * @return {@code true} se estiver ligado, {@code false} caso contrario
     */
    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    /**
     * Devolve a bateria do drone.
     *
     * @return o objeto {@link Battery} associado
     */
    public Battery getBattery() {
        return battery;
    }

    /**
     * Devolve o motor do drone.
     *
     * @return o objeto {@link Motor} associado
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Liga o drone, caso a bateria tenha no minimo 50 mAh.
     * Ligar o drone consome 10 mAh.
     */
    public void turnOn() {
        if (battery.getCargaAtual() >= 50) {
            battery.useCharge(10);
            isTurnedOn = true;
            System.out.println("Drone ligado.");
        } else {
            System.out.println("Bateria insuficiente para ligar o drone.");
        }
    }

    /** Desliga o drone. */
    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Drone desligado.");
    }

    /**
     * Liga o drone a corrente para carregar a bateria. So funciona com o
     * drone desligado.
     */
    public void plugToPower() {
        if (!isTurnedOn) {
            battery.carregarTotalmente();
            System.out.println("Bateria carregada.");
        } else {
            System.out.println("Desligue o drone antes de carregar.");
        }
    }

    /**
     * Substitui a bateria do drone. So funciona com o drone desligado e se a
     * nova bateria tiver, no minimo, 500 mAh de capacidade.
     *
     * @param novaBateria a nova bateria a colocar no drone
     */
    public void replaceBattery(Battery novaBateria) {
        if (isTurnedOn) {
            System.out.println("Desligue o drone antes de trocar a bateria.");
            return;
        }
        if (novaBateria.getCapacidadeMaxima() < 500) {
            System.out.println("A nova bateria tem de ter pelo menos 500 mAh.");
            return;
        }
        this.battery = novaBateria;
        System.out.println("Bateria substituida.");
    }

    /**
     * Poe o drone em voo, ligando o motor caso haja carga suficiente para o
     * seu consumo. So funciona com o drone ligado.
     */
    public void fly() {
        if (!isTurnedOn) {
            System.out.println("Ligue o drone antes de voar.");
            return;
        }
        if (battery.useCharge(motor.getConsumption())) {
            motor.turnOn();
            System.out.println("Drone em voo");
        } else {
            System.out.println("Bateria insuficiente para voar.");
        }
    }

    /** Aterra o drone, desligando o motor caso esteja ligado. */
    public void land() {
        if (motor.isTurnedOn()) {
            motor.turnOff();
            System.out.println("Drone aterrado");
        }
    }
}
