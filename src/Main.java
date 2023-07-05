import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static GeradorNPA geradorNPA;
    private static CongruenteLinear congruenteLinear;

    public static void main(String[] args) {
        Servidor servidor = new Servidor(0, 0, new ArrayList<>(), 0, 0,
                9999999999L, 0, Boolean.FALSE, "C", 0, 0, 0, 0, 0);
        menu(servidor);
    }

    public static void menu(Servidor servidor) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados para gerar os NPAs: ");
        System.out.print("Insira o valor de X0: ");
        double valorX0 = input.nextDouble();
        System.out.print("Insira o valor de A: ");
        double valorA = input.nextDouble();
        System.out.print("Insira o valor de C: ");
        double valorC = input.nextDouble();
        System.out.print("Insira o valor de M: ");
        double valorM = input.nextDouble();
        System.out.print("Insira o tempo médio entre chegadas (exponencial): ");
        double tempoMedioChegadas = input.nextDouble();
        System.out.print("Insira o tempo médio entre atendimentos (exponencial): ");
        double tempoMedioAtendimento = input.nextDouble();
        System.out.print( "Insira o tempo de simulação: ");
        double tempoSimulacao = input.nextDouble();

//        geradorNPA.gerarListaNPAs(1, valorA, valorC, valorM, valorX0);

        while (!servidor.getFimSimulacao()) {
            if (Objects.equals(servidor.getProximoEvento(), "C")) {
                processarChegada(servidor);
            } else {
                processarSaida(servidor);
            }
            if (servidor.getProximaChegada() > tempoSimulacao && servidor.getProximaSaida() == 9999999999L) {
                servidor.setFimSimulacao(Boolean.TRUE);
            } else if (servidor.getProximaChegada() > tempoSimulacao) {
                servidor.setProximoEvento("S");
            } else {
                servidor.setProximoEvento(temporizador(servidor));
            }
        }

    }

    private static String temporizador(Servidor servidor) {
        System.out.println("Temporizador:");
        System.out.println("Próxima chegada: " + servidor.getProximaChegada());
        System.out.println("Próxima saída: " + servidor.getProximaSaida());
        if (servidor.getProximaChegada() <= servidor.getProximaSaida()) {
            servidor.setProximoEvento("C");
            return "C";
        } else {
            servidor.setProximoEvento("S");
            return "S";
        }
    }

    private static void processarSaida(Servidor servidor) {
//        servidor.setRelogioSimulacao(servidor.getSaida());
        double relogioMenosUltimoEvento = servidor.getRelogioSimulacao() - servidor.getTempoUltimoEvento();
        if (servidor.getNumeroEmFila() > 0) {
            servidor.setProximaSaida(servidor.getRelogioSimulacao() + gerarEvento(servidor));
            servidor.setAreaSobQuantidade(servidor.getAreaSobQuantidade() + relogioMenosUltimoEvento * servidor.getNumeroEmFila());
            servidor.setNumeroEmFila(servidor.getNumeroEmFila() - 1);
            servidor.getFilaChegada().remove(0);
//            tempoTotalFila
        } else {
            servidor.setAreaSobOcupacao(servidor.getAreaSobOcupacao() + relogioMenosUltimoEvento * servidor.getStatusServidor());
            servidor.setProximaSaida(9999999999L);
            servidor.setStatusServidor(0);
        }
        servidor.setTempoUltimoEvento(servidor.getRelogioSimulacao());
        servidor.setClientesAtendidos(servidor.getClientesAtendidos() + 1);
    }

    private static void processarChegada(Servidor servidor) {
        servidor.setRelogioSimulacao(servidor.getChegada());
        servidor.setProximaChegada(servidor.getRelogioSimulacao() + gerarEvento(servidor));
        if (servidor.getStatusServidor() == 0) {
            servidor.setStatusServidor(1);
            servidor.setProximaSaida(servidor.getRelogioSimulacao() + gerarEvento(servidor));
        } else {
            double relogioMenosUltimoEvento = servidor.getRelogioSimulacao() - servidor.getTempoUltimoEvento();
            servidor.setAreaSobQuantidade(servidor.getAreaSobQuantidade() + relogioMenosUltimoEvento * servidor.getNumeroEmFila());
            servidor.setAreaSobOcupacao(servidor.getAreaSobOcupacao() + relogioMenosUltimoEvento * servidor.getStatusServidor());
            servidor.getFilaChegada().add(servidor.getChegada());
            servidor.setNumeroEmFila(servidor.getNumeroEmFila() + 1);
        }
        servidor.setTempoUltimoEvento(servidor.getRelogioSimulacao());
    }

    private static double gerarEvento(Servidor servidor) {
        return 1.0;
    }

}