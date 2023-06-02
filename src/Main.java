import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Servidor servidor = new Servidor(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, Boolean.FALSE);

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
        int numeroAleatorioChegada = rand.nextInt(40);
        int numeroAleatorioPartida = rand.nextInt(40);

        if (servidor.getListaChegada().isEmpty() && servidor.getRelogio() <= 480) {
            if (servidor.getListaAtendimento().isEmpty()) {
                servidor.getListaAtendimento().add(numeroAleatorioChegada);
                servidor.setOcupado(Boolean.TRUE);
            } else {
                servidor.getListaChegada().add(numeroAleatorioChegada);
            }
        }
        if (!servidor.getListaAtendimento().isEmpty() && servidor.getRelogio() >= servidor.getListaAtendimento().get(0)) {
            servidor.getListaAtendimento().remove(0);
        }
        servidor.setRelogio(servidor.getRelogio() + numeroAleatorioChegada);
        System.out.println("LISTA DE CHEGADA: " + servidor.getListaChegada());
        System.out.println("LISTA DE ATENDIMENTO: " + servidor.getListaAtendimento());
        System.out.println("LISTA DE PARTIDA: " + servidor.getListaPartida());
        System.out.println("RELOGIO: " + servidor.getRelogio());
        System.out.println("OCUPADO: " + servidor.getOcupado());
        menu(servidor);
    }

    private static void opcao2() {
    }


}