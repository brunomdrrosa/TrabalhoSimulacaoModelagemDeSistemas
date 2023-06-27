import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static GeradorNPA geradorNPA;

    public static void main(String[] args) {
        Servidor servidor = new Servidor(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, Boolean.FALSE);
        menu(servidor);
    }

    public static void menu(Servidor servidor) {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1. Gerar uma nova chegada");
        System.out.println("2. Visualizar contadores estatísticos");
        try {
            int opcaoMenu = new Scanner(System.in).nextInt();
            if (opcaoMenu == 1) {
                opcao1(servidor);
            } else if (opcaoMenu == 2) {
                opcao2();
            } else {
                System.out.println("Digite um número de 1 a 2");
                menu(servidor);
            }
        } catch (InputMismatchException e) {
            System.out.println("Você informou um input inválido, retornando ao menu principal");
            menu(servidor);
        }
    }

    private static void opcao1(Servidor servidor) {
        Random rand = new Random();
        int numeroAleatorioChegada = rand.nextInt(40) + 1;
        int numeroAleatorioPartida = rand.nextInt(40) + 1;

        gerarNovaChegada(servidor, numeroAleatorioChegada);
        verificarSeExisteUmaPossivelSaida(servidor, numeroAleatorioPartida);
        verificarSePossivelAdicionarNovoAtendimento(servidor);
        verificarSePossivelFinalizarAtendimento(servidor);
        verificarSePossivelAdicionarNovoAtendimento(servidor);

        System.out.println("LISTA DE CHEGADA: " + servidor.getListaChegada());
        System.out.println("LISTA DE ATENDIMENTO: " + servidor.getListaAtendimento());
        System.out.println("LISTA DE PARTIDA: " + servidor.getListaPartida());
        System.out.println("TEMPOS DE SAÍDA: " + servidor.getTemposSaida());
        System.out.println("RELOGIO: " + servidor.getRelogio());
        System.out.println("OCUPADO: " + servidor.getOcupado());

        menu(servidor);
    }

    private static void opcao2() {
    }

    private static void verificarSeExisteUmaPossivelSaida(Servidor servidor, int numeroAleatorioPartida) {
        if (servidor.getTemposSaida().size() >= 1) {
            int posicao = servidor.getTemposSaida().size() - 1;
            servidor.getTemposSaida().add(servidor.getTemposSaida().get(posicao) + numeroAleatorioPartida);
        } else {
            servidor.getTemposSaida().add(servidor.getRelogio() + numeroAleatorioPartida);
        }
    }

    private static void gerarNovaChegada(Servidor servidor, int numeroAleatorioChegada) {
        servidor.getListaChegada().add(numeroAleatorioChegada);
        servidor.setRelogio(servidor.getRelogio() + numeroAleatorioChegada);
    }

    private static void verificarSePossivelAdicionarNovoAtendimento(Servidor servidor) {
        Random rand = new Random();
        if (servidor.getListaAtendimento().isEmpty()) {
            if (!servidor.getListaChegada().isEmpty()) {
                int atendimento = servidor.getListaChegada().remove(0);
                servidor.getListaAtendimento().add(atendimento);
                servidor.setOcupado(Boolean.TRUE);
            } else {
                int numeroAleatorioPartida = rand.nextInt(40) + 1;
                servidor.getListaChegada().add(rand.nextInt(40) + 1);
                verificarSeExisteUmaPossivelSaida(servidor, numeroAleatorioPartida);
                servidor.setOcupado(Boolean.FALSE);
            }
        }
    }

    private static void verificarSePossivelFinalizarAtendimento(Servidor servidor) {
//        while (!servidor.getTemposSaida().isEmpty() && servidor.getRelogio() >= servidor.getTemposSaida().get(0)) {
            if (servidor.getRelogio() >= servidor.getTemposSaida().get(0)) {
                if (!servidor.getListaAtendimento().isEmpty()) {
                    servidor.getListaPartida().add(servidor.getListaAtendimento().get(0));
                    servidor.getListaAtendimento().remove(0);
                } else {
                    servidor.getListaPartida().add(servidor.getListaChegada().get(0));
                    servidor.getListaChegada().remove(0);
                }
                servidor.getTemposSaida().remove(0);
                if (servidor.getListaAtendimento().size() >= 1) {
                    servidor.getListaAtendimento().add(servidor.getListaChegada().get(0));
                    servidor.getListaChegada().remove(0);
                }
            }
//        }
    }

}