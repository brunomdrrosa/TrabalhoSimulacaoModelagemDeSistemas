public class CongruenteLinear {
    private final Integer numeroNpas;
    private final Integer valorA;
    private final Integer valorC;
    private final Integer valorM;
    private final Integer valorX0;

    public CongruenteLinear(Integer numeroNpas, Integer valorA, Integer valorC, Integer valorM, Integer valorX0) {
        this.numeroNpas = numeroNpas;
        this.valorA = valorA;
        this.valorC = valorC;
        this.valorM = valorM;
        this.valorX0 = valorX0;
    }

    public Integer getNumeroNpas() {
        return numeroNpas;
    }

    public Integer getValorA() {
        return valorA;
    }

    public Integer getValorC() {
        return valorC;
    }

    public Integer getValorM() {
        return valorM;
    }

    public Integer getValorX0() {
        return valorX0;
    }
}
