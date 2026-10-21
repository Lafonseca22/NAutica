/*
 * Laboratorio 02.02 - Definicao de Classes + Selecao (TravelCard)
 *
 * Simula um cartao de viagens eletronico para transportes publicos.
 * Reune os Niveis 1 a 5 do enunciado (incluindo descontos).
 *
 * Transportes: M-Metro, T-Train(Comboio), B-Bus(Autocarro), F-Ferry.
 */
public class TravelCard {

    // ---------------- Atributos ----------------
    private double saldo;            // saldo disponivel no cartao
    private boolean inicializado;    // o cartao ja foi carregado a 1a vez?
    private boolean emUtilizacao;    // ha uma viagem a decorrer?
    private char transporteAtual;    // M, T, B, F  (' ' = nenhum)
    private int totalViagens;        // numero de viagens concluidas

    // ---------------- Construtor ----------------
    public TravelCard() {
        saldo = 0.0;
        inicializado = false;
        emUtilizacao = false;
        transporteAtual = ' ';
        totalViagens = 0;
    }

    // ---------------- Auxiliares ----------------
    // Preco base de cada transporte.
    private double getPriceForTransport(char transporte) {
        switch (transporte) {
            case 'M': return 0.90;   // Metro
            case 'T': return 2.30;   // Train / Comboio
            case 'B': return 1.90;   // Bus / Autocarro
            case 'F': return 0.85;   // Ferry
            default:  return 0.0;
        }
    }

    // Nome por extenso de cada transporte.
    private String getTransportName(char transporte) {
        switch (transporte) {
            case 'M': return "Metro";
            case 'T': return "Comboio";
            case 'B': return "Autocarro";
            case 'F': return "Ferry";
            default:  return "Nenhum";
        }
    }

    private boolean isTransporteValido(char transporte) {
        return transporte == 'M' || transporte == 'T'
                || transporte == 'B' || transporte == 'F';
    }

    // ---------------- Nivel 1: showInfo ----------------
    public void showInfo() {
        System.out.println("*** INFORMACAO NO CARTAO ***");
        System.out.printf("Saldo            : %.2f%n", saldo);
        System.out.println("Inicializado     : " + (inicializado ? "SIM" : "NAO"));
        System.out.println("Total de viagens : " + totalViagens);
        System.out.println("Em utilizacao    : " + (emUtilizacao ? "SIM" : "NAO"));
        if (emUtilizacao) {   // Nivel 4: mostrar o transporte em uso
            System.out.println("Transporte       : " + getTransportName(transporteAtual));
        }
        System.out.println();
    }

    // ---------------- Nivel 2: initialize ----------------
    public void initialize(double montante) {
        if (inicializado) {
            System.out.println("ERRO: o cartao so pode ser inicializado uma vez.");
            return;
        }
        if (montante < 10.0) {
            System.out.println("ERRO: o valor minimo de carregamento e 10,00 EUR.");
            return;
        }
        saldo = montante;
        inicializado = true;
        showInfo();
    }

    // Preco da viagem do transporte atualmente em uso.
    public double getTripPrice() {
        return getPriceForTransport(transporteAtual);
    }

    // ---------------- Nivel 3: beginTrip ----------------
    public void beginTrip(char transporte) {
        if (!inicializado) {
            System.out.println("ERRO: o cartao tem de estar inicializado.");
            return;
        }
        if (!isTransporteValido(transporte)) {
            System.out.println("ERRO: transporte invalido (use M, T, B ou F).");
            return;
        }
        if (emUtilizacao) {
            System.out.println("ERRO: ja existe uma viagem a decorrer (valide a saida).");
            return;
        }
        // Preco ja com o desconto aplicado (Nivel 5).
        double preco = getPriceForTransport(transporte) * (1 - getDiscount());
        if (saldo < preco) {
            System.out.println("ERRO: saldo insuficiente para esta viagem.");
            return;
        }
        transporteAtual = transporte;
        saldo = saldo - preco;
        emUtilizacao = true;
        showInfo();
    }

    // ---------------- Nivel 4: endTrip ----------------
    public void endTrip() {
        if (!inicializado) {
            System.out.println("ERRO: o cartao tem de estar inicializado.");
            return;
        }
        if (!emUtilizacao) {
            System.out.println("ERRO: nao existe nenhuma viagem a decorrer.");
            return;
        }
        emUtilizacao = false;
        transporteAtual = ' ';
        totalViagens++;
        showInfo();
    }

    // ---------------- Nivel 5: showAvailableTrips ----------------
    public void showAvailableTrips() {
        if (!inicializado) {
            System.out.println("ERRO: o cartao tem de estar inicializado.");
            return;
        }
        if (emUtilizacao) {
            System.out.println("ERRO: nao e possivel durante uma viagem.");
            return;
        }
        System.out.println("*** VIAGENS DISPONIVEIS ***");
        System.out.println("Metro     : " + (int) (saldo / getPriceForTransport('M')));
        System.out.println("Comboio   : " + (int) (saldo / getPriceForTransport('T')));
        System.out.println("Autocarro : " + (int) (saldo / getPriceForTransport('B')));
        System.out.println("Ferry     : " + (int) (saldo / getPriceForTransport('F')));
        System.out.println();
    }

    // ---------------- Nivel 5: recharge ----------------
    public void recharge(double montante) {
        if (!inicializado) {
            System.out.println("ERRO: o cartao tem de estar inicializado.");
            return;
        }
        if (montante < 10.0) {
            System.out.println("ERRO: o valor minimo de recarregamento e 10,00 EUR.");
            return;
        }
        saldo = saldo + montante;
        showInfo();
    }

    // ---------------- Nivel 5: getDiscount ----------------
    // Desconto (fracao) em funcao do total de viagens ja efetuadas.
    public double getDiscount() {
        if (totalViagens >= 100) {
            return 0.05;
        } else if (totalViagens >= 50) {
            return 0.04;
        } else if (totalViagens >= 20) {
            return 0.03;
        } else if (totalViagens >= 10) {
            return 0.02;
        }
        return 0.0;
    }
}
