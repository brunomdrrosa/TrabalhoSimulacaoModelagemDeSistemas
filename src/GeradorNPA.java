import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GeradorNPA {

    public ArrayList<Double> gerarListaNPAs(Integer numeroNpas,
                                                   double valorA,
                                                   double valorC,
                                                   double valorM,
                                                   double valorX0) {
        CongruenteLinear congruenteLinear = new CongruenteLinear(numeroNpas, valorA, valorC, valorM, valorX0);
        ArrayList<Integer> ultimoNumeroGerado = new ArrayList<>();
        ArrayList<Double> listaNpas = new ArrayList<>();
//        ultimoNumeroGerado.add(congruenteLinear.getValorX0());

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
            double npaArredondado = new BigDecimal(valorNPA).setScale(4, RoundingMode.HALF_UP).doubleValue();
            listaNpas.add(npaArredondado);
        }
        return listaNpas;
    }

}
