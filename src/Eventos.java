public class Eventos {
    private final double tempoChegada;
    private final double tempoSaida;

    public Eventos(double tempoChegada, double tempoSaida) {
        this.tempoChegada = tempoChegada;
        this.tempoSaida = tempoSaida;
    }

    public double getTempoChegada() {
        return tempoChegada;
    }

    public double getTempoSaida() {
        return tempoSaida;
    }
}
