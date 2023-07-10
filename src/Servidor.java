import java.util.ArrayList;

public class Servidor {
    private Integer statusServidor = 0;
    private Integer numeroEmFila = 0;
    private final ArrayList<Double> filaChegada = new ArrayList<>();
    private double tempoUltimoEvento = 0;
    private double relogioSimulacao = 0;
    private double proximaSaida = 9999999999L;
    private double proximaChegada = 0;
    private Boolean fimSimulacao = Boolean.FALSE;
    private String proximoEvento = "C";
    private double areaSobQuantidade = 0;
    private double areaSobOcupacao = 0;
    private Integer clientesAtendidos = 0;
    private Integer indice = 0;
    private double tempoTotalFila = 0;

    public Servidor() {
    }

    public double getTempoTotalFila() {
        return tempoTotalFila;
    }

    public void setTempoTotalFila(double tempoTotalFila) {
        this.tempoTotalFila = tempoTotalFila;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public Integer getStatusServidor() {
        return statusServidor;
    }

    public void setStatusServidor(Integer statusServidor) {
        this.statusServidor = statusServidor;
    }

    public Integer getNumeroEmFila() {
        return numeroEmFila;
    }

    public void setNumeroEmFila(Integer numeroEmFila) {
        this.numeroEmFila = numeroEmFila;
    }

    public ArrayList<Double> getFilaChegada() {
        return filaChegada;
    }

    public double getTempoUltimoEvento() {
        return tempoUltimoEvento;
    }

    public void setTempoUltimoEvento(double tempoUltimoEvento) {
        this.tempoUltimoEvento = tempoUltimoEvento;
    }

    public double getRelogioSimulacao() {
        return relogioSimulacao;
    }

    public void setRelogioSimulacao(double relogioSimulacao) {
        this.relogioSimulacao = relogioSimulacao;
    }

    public double getProximaSaida() {
        return proximaSaida;
    }

    public void setProximaSaida(double proximaSaida) {
        this.proximaSaida = proximaSaida;
    }

    public double getProximaChegada() {
        return proximaChegada;
    }

    public void setProximaChegada(double proximaChegada) {
        this.proximaChegada = proximaChegada;
    }

    public Boolean getFimSimulacao() {
        return fimSimulacao;
    }

    public void setFimSimulacao(Boolean fimSimulacao) {
        this.fimSimulacao = fimSimulacao;
    }

    public String getProximoEvento() {
        return proximoEvento;
    }

    public void setProximoEvento(String proximoEvento) {
        this.proximoEvento = proximoEvento;
    }

    public double getAreaSobQuantidade() {
        return areaSobQuantidade;
    }

    public void setAreaSobQuantidade(double areaSobQuantidade) {
        this.areaSobQuantidade = areaSobQuantidade;
    }

    public double getAreaSobOcupacao() {
        return areaSobOcupacao;
    }

    public void setAreaSobOcupacao(double areaSobOcupacao) {
        this.areaSobOcupacao = areaSobOcupacao;
    }

    public Integer getClientesAtendidos() {
        return clientesAtendidos;
    }

    public void setClientesAtendidos(Integer clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }

}