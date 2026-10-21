import java.util.Locale;

/**
 * Representa um barco telecomandado, composto por uma {@link Battery} e um
 * {@link Motor}, com uma rota definida pelos pontos cardeais.
 *
 * <p>Rotas possiveis: {@code 'N'} (Norte), {@code 'S'} (Sul), {@code 'E'}
 * (Este) e {@code 'W'} (Oeste).</p>
 *
 * @author Leonardo Fonseca
 * @version 1.0
 */
public class RemoteControlledBoat {

    /** Rota atual do barco: N, S, E, W (ou espaco se nao houver rota). */
    private char route;

    /** Indica se o barco esta ligado ({@code true}) ou desligado. */
    private boolean isTurnedOn;

    /** A bateria do barco. */
    private Battery battery;

    /** O motor do barco. */
    private Motor motor;

    /**
     * Cria um barco desligado, com bateria nova de 1500 mAh, motor com
     * consumo de 150 mAh e sem rota atribuida.
     */
    public RemoteControlledBoat() {
        this.isTurnedOn = false;
        this.battery = new Battery(1500);
        this.motor = new Motor(150);
        this.route = ' ';
    }

    /**
     * Devolve a rota atual do barco.
     *
     * @return o caracter da rota (N, S, E, W ou espaco)
     */
    public char getRoute() {
        return route;
    }

    /**
     * Indica se o barco esta ligado.
     *
     * @return {@code true} se estiver ligado, {@code false} caso contrario
     */
    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    /**
     * Devolve a bateria do barco.
     *
     * @return o objeto {@link Battery} associado
     */
    public Battery getBattery() {
        return battery;
    }

    /**
     * Devolve o motor do barco.
     *
     * @return o objeto {@link Motor} associado
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Verifica se uma rota e valida.
     *
     * @param rota o caracter da rota a validar
     * @return {@code true} se for N, S, E ou W
     */
    private boolean isRotaValida(char rota) {
        return rota == 'N' || rota == 'S' || rota == 'E' || rota == 'W';
    }

    /**
     * Devolve o nome por extenso de uma rota.
     *
     * @param rota o caracter da rota
     * @return o nome da rota (Norte, Sul, Este, Oeste ou Nenhuma)
     */
    private String getRouteName(char rota) {
        switch (rota) {
            case 'N': return "Norte";
            case 'S': return "Sul";
            case 'E': return "Este";
            case 'W': return "Oeste";
            default:  return "Nenhuma";
        }
    }

    /**
     * Liga o barco, caso a bateria tenha no minimo 75 mAh.
     * Ligar o barco consome 15 mAh.
     */
    public void turnOn() {
        if (battery.getCargaAtual() >= 75) {
            battery.useCharge(15);
            isTurnedOn = true;
            System.out.println("Barco ligado.");
        } else {
            System.out.println("Bateria insuficiente para ligar o barco.");
        }
    }

    /** Desliga o barco e remove a rota atribuida. */
    public void turnOff() {
        isTurnedOn = false;
        route = ' ';
        System.out.println("Barco desligado.");
    }

    /**
     * Liga o barco a corrente para carregar a bateria. So funciona com o
     * barco desligado.
     */
    public void plugToPower() {
        if (!isTurnedOn) {
            battery.carregarTotalmente();
            System.out.println("Bateria carregada.");
        } else {
            System.out.println("Desligue o barco antes de carregar.");
        }
    }

    /**
     * Substitui a bateria do barco. So funciona com o barco desligado e se a
     * nova bateria tiver, no minimo, 750 mAh de capacidade.
     *
     * @param novaBateria a nova bateria a colocar no barco
     */
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

    /**
     * Faz o barco navegar a vante (para a frente) na rota indicada.
     * Liga o motor se houver carga suficiente para o consumo e a rota for
     * valida. So funciona com o barco ligado.
     *
     * @param rota rota a seguir (N, S, E ou W)
     */
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

    /**
     * Faz o barco navegar a re (para tras) na rota indicada. Desliga o motor
     * e volta a liga-lo no sentido oposto, se houver carga suficiente.
     *
     * @param rota rota a seguir (N, S, E ou W)
     */
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
