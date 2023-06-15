import java.util.List;

public class Servidor {
    private List<Integer> listaChegada;
    private List<Integer> listaAtendimento;
    private List<Integer> listaPartida;
    private List<Integer> temposSaida;
    private Integer relogio;
    private Boolean ocupado;

    public Servidor(List<Integer> listaChegada, List<Integer> listaAtendimento, List<Integer> listaPartida, List<Integer> temposSaida, Integer relogio, Boolean ocupado) {
        this.listaChegada = listaChegada;
        this.listaAtendimento = listaAtendimento;
        this.listaPartida = listaPartida;
        this.temposSaida = temposSaida;
        this.relogio = relogio;
        this.ocupado = ocupado;
    }

    public List<Integer> getListaChegada() {
        return listaChegada;
    }

    public List<Integer> getListaAtendimento() {
        return listaAtendimento;
    }

    public List<Integer> getListaPartida() {
        return listaPartida;
    }

    public List<Integer> getTemposSaida() {
        return temposSaida;
    }

    public Integer getRelogio() {
        return relogio;
    }

    public void setRelogio(Integer relogio) {
        this.relogio = relogio;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
}
