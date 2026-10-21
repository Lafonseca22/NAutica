/*
 * Laboratorio 03.01 - classe RemoteControlledBoat (Nivel 5).
 *
 * Barco telecomandado: TEM UMA Battery, TEM UM Motor e uma rota.
 * Rota (pontos cardeais): N-Norte, S-Sul, E-Este, W-Oeste.
 */
import java.util.Locale;

public class RemoteControlledBoat {

    private char route;            // N, S, E, W  (' ' = sem rota)
    private boolean isTurnedOn;    // ligado ou desligado
    private Battery battery;       // bateria
    private Motor motor;           // motor

    // Construtor: desligado, bateria 1500 mAh, motor 150 mAh, sem rota.
    public RemoteControlledBoat() {
        this.isTurnedOn = false;
        this.battery = new Battery(1500);
        this.motor = new Motor(150);
        this.route = ' ';
    }

    public char getRoute() {
        return route;
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

    private boolean isRotaValida(char rota) {
        return rota == 'N' || rota == 'S' || rota == 'E' || rota == 'W';
    }

    private String getRouteName(char rota) {
        switch (rota) {
            case 'N': return "Norte";
            case 'S': return "Sul";
            case 'E': return "Este";
            case 'W': return "Oeste";
            default:  return "Nenhuma";
        }
    }

    // Liga o barco: so com, no minimo, 75 mAh. Ligar gasta 15 mAh.
    public void turnOn() {
        if (battery.getCargaAtual() >= 75) {
            battery.useCharge(15);
            isTurnedOn = true;
            System.out.println("Barco ligado.");
        } else {
            System.out.println("Bateria insuficiente para ligar o barco.");
        }
    }

    // Desligar coloca o barco sem rota.
    public void turnOff() {
        isTurnedOn = false;
        route = ' ';
        System.out.println("Barco desligado.");
    }

    public void plugToPower() {
        if (!isTurnedOn) {
            battery.carregarTotalmente();
            System.out.println("Bateria carregada.");
        } else {
            System.out.println("Desligue o barco antes de carregar.");
        }
    }

    public void replaceBattery(Battery novaBateria) {
        if (isTurnedOn) {
            System.out.println("Desligue o barco antes de trocar a bateria.");
            return;
        }
        if (novaBateria.getCapacidadeMaxima() < 750) {
            System.out.println("A nova bateria tem de ter pelo menos 750 mAh.");
            return;
        }
        this.battery = novaBateria;
        System.out.println("Bateria substituida.");
    }

    // Navegar a vante (para a frente).
    public void navigateForward(char rota) {
        if (!isTurnedOn) {
            System.out.println("Ligue o barco antes de navegar.");
            return;
        }
        if (!isRotaValida(rota)) {
            System.out.println("Rota invalida (use N, S, E ou W).");
            return;
        }
        if (battery.useCharge(motor.getConsumption())) {
            motor.turnOn();
            route = rota;
            System.out.printf(Locale.forLanguageTag("pt-PT"),
                    "Barco a navegar a vante - Rota: %s - Percentagem restante de carga %.1f %%%n",
                    getRouteName(rota), battery.getPercentagemCarga());
        } else {
            System.out.println("Bateria insuficiente para navegar.");
        }
    }

    // Navegar a re (para tras): desliga e volta a ligar o motor em sentido oposto.
    public void navigateBackwards(char rota) {
        if (!isTurnedOn) {
            System.out.println("Ligue o barco antes de navegar.");
            return;
        }
        if (!isRotaValida(rota)) {
            System.out.println("Rota invalida (use N, S, E ou W).");
            return;
        }
        if (motor.isTurnedOn()) {
            motor.turnOff();
        }
        if (battery.useCharge(motor.getConsumption())) {
            motor.turnOn();
            route = rota;
            System.out.printf(Locale.forLanguageTag("pt-PT"),
                    "Barco a navegar a re - Rota: %s - Percentagem restante de carga %.1f %%%n",
                    getRouteName(rota), battery.getPercentagemCarga());
        } else {
            System.out.println("Bateria insuficiente para navegar.");
        }
    }
}
