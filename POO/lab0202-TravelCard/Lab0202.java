/*
 * Laboratorio 02.02 - main que testa o TravelCard, incluindo casos de erro.
 */
public class Lab0202 {

    public static void main(String[] args) {

        TravelCard cartao = new TravelCard();

        System.out.println("--- Estado inicial ---");
        cartao.showInfo();

        System.out.println("--- Tentar viajar sem inicializar (deve dar erro) ---");
        cartao.beginTrip('M');

        System.out.println("--- Inicializar com valor invalido (< 10) ---");
        cartao.initialize(5);

        System.out.println("--- Inicializar com 20,00 ---");
        cartao.initialize(20);

        System.out.println("--- Iniciar viagem de Metro ---");
        cartao.beginTrip('M');

        System.out.println("--- Tentar iniciar outra sem terminar (deve dar erro) ---");
        cartao.beginTrip('T');

        System.out.println("--- Terminar viagem ---");
        cartao.endTrip();

        System.out.println("--- Viagens disponiveis com o saldo atual ---");
        cartao.showAvailableTrips();

        System.out.println("--- Recarregar 10,00 ---");
        cartao.recharge(10);
    }
}
