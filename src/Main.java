import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
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
        CongruenteLinear metodoCongruenteLinear = new CongruenteLinear(valorA, valorC, valorM, valorX0);
        Tempos tempos = new Tempos();

        gerarSementes(tempos, metodoCongruenteLinear, tempoSimulacao, tempoMedioChegadas, tempoMedioAtendimento);
        iniciarSimulacao(tempos, servidor);
    }

    private static void iniciarSimulacao(Tempos tempos, Servidor servidor) {
        simular(tempos, servidor);
    }

    private static void simular(Tempos tempos, Servidor servidor) {
        Eventos eventos = tempos.getListaDeEventos().get(servidor.getIndice());
        Eventos proximoEvento = tempos.getListaDeEventos().get(servidor.getIndice());

        if (Objects.equals(servidor.getProximoEvento(), "C")) {
            processarChegada(eventos, proximoEvento, servidor);
        } else if (Objects.equals(servidor.getProximoEvento(), "S")) {
            processarSaida(eventos, proximoEvento, servidor);
        }

        servidor.setIndice(servidor.getIndice() + 1);

        while (servidor.getFimSimulacao() == Boolean.FALSE) {
            if (Objects.equals(servidor.getProximoEvento(), "C")) {
                processarChegada(eventos, proximoEvento, servidor);
            } else {
                processarSaida(eventos, proximoEvento, servidor);
            }
            if (servidor.getProximaChegada() > 480 && servidor.getProximaSaida() == 9999999999L) {
                servidor.setFimSimulacao(Boolean.TRUE);
            } else if (servidor.getProximaChegada() > 480) {
                servidor.setProximoEvento("S");
            } else {
                servidor.setProximoEvento(temporiza(servidor));
            }
        }
        exibirEstados(servidor);
    }

    private static String temporiza(Servidor servidor) {
        if (servidor.getProximaChegada() <= servidor.getProximaSaida()) {
            servidor.setProximoEvento("C");
        } else {
            servidor.setProximoEvento("S");
        }
        return servidor.getProximoEvento();
    }

    private static void processarSaida(Eventos eventos, Eventos proximoEvento, Servidor servidor) {
        double saida = eventos.getTempoSaida();
        servidor.setRelogioSimulacao(servidor.getRelogioSimulacao() + saida);

        if (servidor.getNumeroEmFila() > 0) {
            servidor.setProximaSaida(servidor.getRelogioSimulacao() + proximoEvento.getTempoSaida());
            calcularAreaSobQuantidade(servidor);
            servidor.getFilaChegada().remove(0);
            servidor.setNumeroEmFila(servidor.getFilaChegada().size());
            servidor.setTempoTotalFila(servidor.getTempoTotalFila() + servidor.getRelogioSimulacao());
        } else {
            calcularAreaSobOcupacao(servidor);
            servidor.setProximaSaida(9999999999L);
            servidor.setStatusServidor(0);
        }
        servidor.setTempoUltimoEvento(servidor.getRelogioSimulacao());
        servidor.setClientesAtendidos(servidor.getClientesAtendidos() + 1);
    }

    private static void processarChegada(Eventos eventos, Eventos proximoEvento, Servidor servidor) {
        double chegada = eventos.getTempoChegada();
        servidor.setRelogioSimulacao(servidor.getRelogioSimulacao() + chegada);
        servidor.setProximaChegada(servidor.getRelogioSimulacao() + proximoEvento.getTempoChegada());

        if (servidor.getStatusServidor() == 0) {
            servidor.setStatusServidor(1);
            servidor.setProximaSaida(servidor.getRelogioSimulacao() + eventos.getTempoSaida());
        } else {
            calcularAreaSobQuantidade(servidor);
            calcularAreaSobOcupacao(servidor);
            servidor.getFilaChegada().add(servidor.getRelogioSimulacao());
            servidor.setNumeroEmFila(servidor.getFilaChegada().size());
        }
        servidor.setTempoUltimoEvento(servidor.getRelogioSimulacao());
    }

    private static void calcularAreaSobOcupacao(Servidor servidor) {
        double relogio = servidor.getRelogioSimulacao();
        double ultimoEvento = servidor.getTempoUltimoEvento();

        double subtracao = relogio - ultimoEvento;
        double soma = servidor.getAreaSobOcupacao() + subtracao;

        double multiplicacao = soma * servidor.getStatusServidor();

        servidor.setAreaSobOcupacao(multiplicacao);
    }

    private static void calcularAreaSobQuantidade(Servidor servidor) {
        double relogio = servidor.getRelogioSimulacao();
        double ultimoEvento = servidor.getTempoUltimoEvento();

        double subtracao = relogio - ultimoEvento;
        double soma = servidor.getAreaSobQuantidade() + subtracao;

        double multiplicacao = soma * servidor.getNumeroEmFila();

        servidor.setAreaSobQuantidade(multiplicacao);
    }


    private static void exibirEstados(Servidor servidor) {
        final DecimalFormat df = new DecimalFormat("0.00");
        final DecimalFormat dfQuatroCasas = new DecimalFormat("0.0000");

        System.out.println();
        System.out.println("Status do servidor: " + servidor.getStatusServidor());
        System.out.println("Número em fila: " + servidor.getNumeroEmFila());
        System.out.println("Fila de chegada: " + servidor.getFilaChegada());
        System.out.println("Tempo do último evento: " + df.format(servidor.getTempoUltimoEvento()));
        System.out.println("Relógio da simulação: " + df.format(servidor.getRelogioSimulacao()));
        System.out.println("Próxima chegada: " + df.format(servidor.getProximaChegada()));
        System.out.println("Próxima saída: " + servidor.getProximaSaida());
        System.out.println("Fim da simulação: " + servidor.getFimSimulacao());
        System.out.println("Próximo evento: " + servidor.getProximoEvento());
        System.out.println("Tempo total fila: " + df.format(servidor.getTempoTotalFila()));
        System.out.println("Área sob quantidade: " + df.format(servidor.getAreaSobQuantidade()));
        System.out.println("Área sob ocupação: " + df.format(servidor.getAreaSobOcupacao()));
        System.out.println("Clientes atendidos: " + servidor.getClientesAtendidos());
        System.out.println();
        System.out.println("Tempo médio em fila: " + dfQuatroCasas.format(servidor.getTempoTotalFila() / servidor.getClientesAtendidos()));
        System.out.println("Número médio em fila: " + dfQuatroCasas.format(servidor.getAreaSobQuantidade() / servidor.getRelogioSimulacao()));
        System.out.println("Taxa de ocupação: " + dfQuatroCasas.format((servidor.getAreaSobOcupacao() / servidor.getRelogioSimulacao()) * 100) + "%");
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

    private static void gerarSementes(Tempos tempos, CongruenteLinear metodoCongruenteLinear, double tempoSimulacao,
                                      double tempoMedioChegadas, double tempoMedioAtendimento) {
        ArrayList<Double> sementes = new ArrayList<>();
        double sementesSomadas = 0;

        while (sementesSomadas < tempoSimulacao) {
            double eventoChegada = gerarEvento(metodoCongruenteLinear, tempoMedioChegadas);
            double eventoSaida = gerarEvento(metodoCongruenteLinear, tempoMedioAtendimento);
            sementes.add(eventoChegada);
            sementes.add(eventoSaida);
            sementesSomadas = sementes.stream().reduce(0.0, Double::sum);
            Eventos eventos = new Eventos(eventoChegada, eventoSaida);
            tempos.getListaDeEventos().add(eventos);
        }
    }

}