public class CongruenteLinear {
    private double numeroNpas;
    private double valorA;
    private double valorC;
    private double valorM;
    private double valorX0;

    public CongruenteLinear(double numeroNpas, double valorA, double valorC, double valorM, double valorX0) {
        this.numeroNpas = numeroNpas;
        this.valorA = valorA;
        this.valorC = valorC;
        this.valorM = valorM;
        this.valorX0 = valorX0;
    }

    public double getNumeroNpas() {
        return numeroNpas;
    }

    public void setNumeroNpas(double numeroNpas) {
        this.numeroNpas = numeroNpas;
    }

    public double getValorA() {
        return valorA;
    }

    public void setValorA(double valorA) {
        this.valorA = valorA;
    }

    public double getValorC() {
        return valorC;
    }

    public void setValorC(double valorC) {
        this.valorC = valorC;
    }

    public double getValorM() {
        return valorM;
    }

    public void setValorM(double valorM) {
        this.valorM = valorM;
    }

    public double getValorX0() {
        return valorX0;
    }

    public void setValorX0(double valorX0) {
        this.valorX0 = valorX0;
    }
}
