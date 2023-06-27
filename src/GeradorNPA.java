import java.util.ArrayList;

public class GeradorNPA {

    public static void main(String[] args) {
        CongruenteLinear congruenteLinear = new CongruenteLinear(10, 3, 7, 128, 28);
        ArrayList<Integer> ultimoNumeroGerado = new ArrayList<>();
        ultimoNumeroGerado.add(congruenteLinear.getValorX0());

        for (int i = 0; i < congruenteLinear.getNumeroNpas(); i++) {
            double formula = (ultimoNumeroGerado.get(i) * congruenteLinear.getValorA() + congruenteLinear.getValorC()) / (double) congruenteLinear.getValorM();
            double resultado;

            if (formula < 1) {
                resultado = formula * congruenteLinear.getValorM();
            } else {
                int numeroParaDiminuir = Integer.parseInt(String.valueOf(formula).substring(0, 1));
                resultado = (formula - numeroParaDiminuir) * congruenteLinear.getValorM();
            }

            ultimoNumeroGerado.add((int) resultado);
            double valorNPA = resultado / (congruenteLinear.getValorM() - 1);
            System.out.println(valorNPA);
            System.out.println("Valor x" + (i + 1) + ": " + resultado);
            System.out.println("NPA x" + (i + 1) + ": " + String.format("%.4f", valorNPA));
            System.out.println();
        }
    }

    public Integer teste() {
        return 1;
    }
}
