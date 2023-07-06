public class Evento {
    private double tempoChegada;
    private double tempoSaida;

    public Evento(double tempoChegada, double tempoSaida) {
        this.tempoChegada = tempoChegada;
        this.tempoSaida = tempoSaida;
    }

    public double getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(double tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public double getTempoSaida() {
        return tempoSaida;
    }

    public void setTempoSaida(double tempoSaida) {
        this.tempoSaida = tempoSaida;
    }
}
