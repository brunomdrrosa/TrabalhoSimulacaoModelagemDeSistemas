import java.util.List;

public class Servidor {
    private List<Integer> listaChegada;
    private List<Integer> listaAtendimento;
    private List<Integer> listaPartida;
    private Integer relogio;
    private Boolean ocupado;

    public Servidor(List<Integer> listaChegada, List<Integer> listaAtendimento, List<Integer> listaPartida, Integer relogio, Boolean ocupado) {
        this.listaChegada = listaChegada;
        this.listaAtendimento = listaAtendimento;
        this.listaPartida = listaPartida;
        this.relogio = relogio;
        this.ocupado = ocupado;
    }

    public List<Integer> getListaChegada() {
        return listaChegada;
    }

    public void setListaChegada(List<Integer> listaChegada) {
        this.listaChegada = listaChegada;
    }

    public List<Integer> getListaAtendimento() {
        return listaAtendimento;
    }

    public void setListaAtendimento(List<Integer> listaAtendimento) {
        this.listaAtendimento = listaAtendimento;
    }

    public List<Integer> getListaPartida() {
        return listaPartida;
    }

    public void setListaPartida(List<Integer> listaPartida) {
        this.listaPartida = listaPartida;
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
