import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static GeradorNPA geradorNPA;
    private static CongruenteLinear congruenteLinear;

    public static void main(String[] args) {
        Servidor servidor = new Servidor(0, 0, new ArrayList(), 0, 0,
                9999999999L, Boolean.FALSE, "C", 0, 0, 0, 0, 0);
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

        System.out.println(valorX0);
        System.out.println(valorA);
        System.out.println(valorC);
        System.out.println(valorM);
        System.out.println(tempoMedioChegadas);
        System.out.println(tempoMedioAtendimento);
        System.out.println(tempoSimulacao);

//        geradorNPA.gerarListaNPAs(1, valorA, valorC, valorM, valorX0);
    }

    private static void opcao1(Servidor servidor) {
        processarChegada(servidor);
    }

    private static void processarChegada(Servidor servidor) {
        servidor.setRelogioSimulacao(servidor.getChegada());
//        relogioSimulacao =
//                proximaChegada = relogioSimulacao
//        if (statusServidor == 0) {
//            statusServidor = 1;
//            proximaSaida =
//        } else {
////            areaSobQuantidade = areaSobQuantidade +
////              areaSobOcupacao = areaSobOcupacao +
////            filaChegada.add()
//              numeroEmFila = numeroEmFila + 1;
//              tempoUltimoEvento =
//        }
//    }

    }
}