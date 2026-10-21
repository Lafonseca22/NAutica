/*
 * Laboratorio 03.01 - main que testa a composicao (Drone e Barco).
 */
public class Lab0301 {

    public static void main(String[] args) {

        System.out.println("===== DRONE =====");
        Drone drone = new Drone();          // bateria 1000, motor 100
        drone.getBattery().carregarTotalmente();   // carregar antes de usar
        drone.turnOn();                     // gasta 10 mAh
        drone.fly();                        // gasta 100 mAh (consumo do motor)
        System.out.printf("Carga do drone: %.1f mAh (%.1f%%)%n",
                drone.getBattery().getCargaAtual(), drone.getBattery().getPercentagemCarga());
        drone.land();
        drone.turnOff();
        drone.plugToPower();                // recarrega com o drone desligado

        System.out.println();
        System.out.println("===== BARCO TELECOMANDADO =====");
        RemoteControlledBoat barco = new RemoteControlledBoat();  // bateria 1500, motor 150
        barco.getBattery().carregarTotalmente();
        barco.turnOn();                     // gasta 15 mAh
        barco.navigateForward('N');         // navega para Norte
        barco.navigateBackwards('S');       // inverte para Sul
        System.out.printf("Carga do barco: %.1f mAh (%.1f%%)%n",
                barco.getBattery().getCargaAtual(), barco.getBattery().getPercentagemCarga());
        barco.turnOff();
    }
}
