/*
 * Laboratorio 03.01 - classe Drone (Niveis 3 e 4).
 *
 * Composicao: um Drone TEM UMA Battery e TEM UM Motor.
 */
public class Drone {

    private boolean isTurnedOn;    // drone ligado ou desligado
    private Battery battery;       // a sua bateria
    private Motor motor;           // o seu motor

    // Construtor sem parametros: desligado, bateria de 1000 mAh, motor de 100 mAh.
    public Drone() {
        this.isTurnedOn = false;
        this.battery = new Battery(1000);
        this.motor = new Motor(100);
    }

    // Segundo construtor: recebe o consumo do motor.
    public Drone(double consumoMotor) {
        this.isTurnedOn = false;
        this.battery = new Battery(1000);
        this.motor = new Motor(consumoMotor);
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public Battery getBattery() {
        return battery;
    }

    public Motor getMotor() {
        return motor;
    }

    // Liga o drone: so com, no minimo, 50 mAh. Ligar gasta 10 mAh.
    public void turnOn() {
        if (battery.getCargaAtual() >= 50) {
            battery.useCharge(10);
            isTurnedOn = true;
            System.out.println("Drone ligado.");
        } else {
            System.out.println("Bateria insuficiente para ligar o drone.");
        }
    }

    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Drone desligado.");
    }

    // Liga a tomada: so carrega com o drone desligado.
    public void plugToPower() {
        if (!isTurnedOn) {
            battery.carregarTotalmente();
            System.out.println("Bateria carregada.");
        } else {
            System.out.println("Desligue o drone antes de carregar.");
        }
    }

    // Substituir bateria: so com o drone desligado e capacidade >= 500 mAh.
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

    // Voar: liga o motor se houver energia para o consumo. So com o drone ligado.
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

    // Aterrar: desliga o motor, se estiver ligado.
    public void land() {
        if (motor.isTurnedOn()) {
            motor.turnOff();
            System.out.println("Drone aterrado");
        }
    }
}
