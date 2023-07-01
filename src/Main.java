import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static GeradorNPA geradorNPA;

    public static void main(String[] args) {
        Servidor servidor = new Servidor(0, 0, new ArrayList(), 0, 0,
                9999999999L, Boolean.FALSE, "C", 0, 0, 0, 0);
        menu(servidor);
    }

    public static void menu(Servidor servidor) {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1. Gerar um novo evento");
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
        processarChegada(servidor.getStatusServidor(), servidor.getProximaSaida(), servidor.getAreaSobQuantidade(), servidor.getAreaSobOcupacao(),
                servidor.getFilaChegada(), servidor.getNumeroEmFila(), servidor.getTempoUltimoEvento());
    }

    private static void processarChegada(Integer statusServidor, Long proximaSaida, Integer areaSobQuantidade,
    Integer areaSobOcupacao, ArrayList filaChegada, Integer numeroEmFila, Integer tempoUltimoEvento) {
//        relogioSimulacao =
//                proximaChegada = relogioSimulacao
        if (statusServidor == 0) {
            statusServidor = 1;
            proximaSaida =
        } else {
//            areaSobQuantidade = areaSobQuantidade +
//              areaSobOcupacao = areaSobOcupacao +
//            filaChegada.add()
              numeroEmFila = numeroEmFila + 1;
              tempoUltimoEvento =
        }
    }

}