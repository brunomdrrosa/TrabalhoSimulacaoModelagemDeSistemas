import java.util.ArrayList;
import java.util.Objects;

public class Main {

    private static GeradorNPA geradorNPA;
    private static CongruenteLinear congruenteLinear;

    public static void main(String[] args) {
        Servidor servidor = new Servidor(0, 0, new ArrayList<>(), 0, 0,
                9999999999L, 0, Boolean.FALSE, "C", 0, 0, 0, 0, 0);
        menu(servidor);
    }

    public static void menu(Servidor servidor) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Insira os dados para gerar os NPAs: ");
//        System.out.print("Insira o valor de X0: ");
//        double valorX0 = input.nextDouble();
//        System.out.print("Insira o valor de A: ");
//        double valorA = input.nextDouble();
//        System.out.print("Insira o valor de C: ");
//        double valorC = input.nextDouble();
//        System.out.print("Insira o valor de M: ");
//        double valorM = input.nextDouble();
//        System.out.print("Insira o tempo médio entre chegadas (exponencial): ");
//        double tempoMedioChegadas = input.nextDouble();
//        System.out.print("Insira o tempo médio entre atendimentos (exponencial): ");
//        double tempoMedioAtendimento = input.nextDouble();
//        System.out.print( "Insira o tempo de simulação: ");
//        double tempoSimulacao = input.nextDouble();
        CongruenteLinear metodoCongruenteLinear = new CongruenteLinear(3, 7, 128, 28);
        double tempoSimulacao = 480;
        double tempoMedioChegadas = 1;
        double tempoMedioAtendimento = 0.5;

        validarSementes(metodoCongruenteLinear, tempoSimulacao, tempoMedioChegadas, tempoMedioAtendimento);

        while (!servidor.getFimSimulacao()) {
            if (Objects.equals(servidor.getProximoEvento(), "C")) {
                processarChegada(metodoCongruenteLinear, servidor);
            } else {
                processarSaida(metodoCongruenteLinear, servidor);
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

    private static void processarSaida(CongruenteLinear metodoCongruenteLinear, Servidor servidor) {
//        servidor.setRelogioSimulacao(servidor.getSaida());
        double relogioMenosUltimoEvento = servidor.getRelogioSimulacao() - servidor.getTempoUltimoEvento();
        if (servidor.getNumeroEmFila() > 0) {
            servidor.setProximaSaida(servidor.getRelogioSimulacao() + gerarEvento(metodoCongruenteLinear, servidor.getProximaSaida()));
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

    private static void processarChegada(CongruenteLinear metodoCongruenteLinear, Servidor servidor) {
        servidor.setRelogioSimulacao(servidor.getChegada());
        servidor.setProximaChegada(servidor.getRelogioSimulacao() + gerarEvento(metodoCongruenteLinear, servidor.getProximaChegada()));
        if (servidor.getStatusServidor() == 0) {
            servidor.setStatusServidor(1);
            servidor.setProximaSaida(servidor.getRelogioSimulacao() + gerarEvento(metodoCongruenteLinear, servidor.getProximaSaida()));
        } else {
            double relogioMenosUltimoEvento = servidor.getRelogioSimulacao() - servidor.getTempoUltimoEvento();
            servidor.setAreaSobQuantidade(servidor.getAreaSobQuantidade() + relogioMenosUltimoEvento * servidor.getNumeroEmFila());
            servidor.setAreaSobOcupacao(servidor.getAreaSobOcupacao() + relogioMenosUltimoEvento * servidor.getStatusServidor());
            servidor.getFilaChegada().add(servidor.getChegada());
            servidor.setNumeroEmFila(servidor.getNumeroEmFila() + 1);
        }
        servidor.setTempoUltimoEvento(servidor.getRelogioSimulacao());
    }

    private static double gerarEvento(CongruenteLinear metodoCongruenteLinear, double evento) {
        double semente = (metodoCongruenteLinear.getValorX0() * metodoCongruenteLinear.getValorA() + metodoCongruenteLinear.getValorC()) % metodoCongruenteLinear.getValorM();
        double npa = semente / (metodoCongruenteLinear.getValorM() - 1);
        double numeroAleatorio = Math.abs(Math.log(npa) * evento);
        metodoCongruenteLinear.setValorX0(semente);

        if (Double.isInfinite(numeroAleatorio)) {
            return 0;
        }

        return numeroAleatorio;
    }

    private static void validarSementes(CongruenteLinear metodoCongruenteLinear, double tempoSimulacao,
                                        double tempoMedioChegadas, double tempoMedioAtendimento) {
        ArrayList<Double> sementes = new ArrayList<>();
        double sementesSomadas = 0;

        while (sementesSomadas < tempoSimulacao) {
            double eventoChegada = gerarEvento(metodoCongruenteLinear, tempoMedioChegadas);
            double eventoSaida = gerarEvento(metodoCongruenteLinear, tempoMedioAtendimento);
            boolean sementeRepetida = sementes.contains(eventoChegada);

            if (sementeRepetida) {
                System.out.println("Semente inválida");
                break;
            }
            sementes.add(eventoChegada);
            sementes.add(eventoSaida);

            sementesSomadas = somarSementes(sementes);
        }
            System.out.println("Tempo total alcançado: " + sementesSomadas);
            System.out.println("Tempo mínimo esperado: " + tempoSimulacao);
    }

    private static double somarSementes(ArrayList<Double> sementes) {
        return sementes.stream().reduce(0.0, Double::sum);
    }


}