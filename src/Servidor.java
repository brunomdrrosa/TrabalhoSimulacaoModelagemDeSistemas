import java.util.ArrayList;

public class Servidor {
    private double statusServidor;
    private double numeroEmFila;
    private ArrayList filaChegada;
    private double tempoUltimoEvento;
    private double relogioSimulacao;
    private double proximaSaida;
    private double proximaChegada;
    private Boolean fimSimulacao;
    private String proximoEvento;
    private double areaSobQuantidade;
    private double areaSobOcupacao;
    private double clientesAtendidos;
    private double valorAnterior;
    private double chegada;

    public Servidor(double statusServidor, double numeroEmFila, ArrayList filaChegada, double tempoUltimoEvento, double relogioSimulacao, double proximaSaida, double proximaChegada, Boolean fimSimulacao, String proximoEvento, double areaSobQuantidade, double areaSobOcupacao, double clientesAtendidos, double valorAnterior, double chegada) {
        this.statusServidor = statusServidor;
        this.numeroEmFila = numeroEmFila;
        this.filaChegada = filaChegada;
        this.tempoUltimoEvento = tempoUltimoEvento;
        this.relogioSimulacao = relogioSimulacao;
        this.proximaSaida = proximaSaida;
        this.proximaChegada = proximaChegada;
        this.fimSimulacao = fimSimulacao;
        this.proximoEvento = proximoEvento;
        this.areaSobQuantidade = areaSobQuantidade;
        this.areaSobOcupacao = areaSobOcupacao;
        this.clientesAtendidos = clientesAtendidos;
        this.valorAnterior = valorAnterior;
        this.chegada = chegada;
    }

    public double getStatusServidor() {
        return statusServidor;
    }

    public void setStatusServidor(double statusServidor) {
        this.statusServidor = statusServidor;
    }

    public double getNumeroEmFila() {
        return numeroEmFila;
    }

    public void setNumeroEmFila(double numeroEmFila) {
        this.numeroEmFila = numeroEmFila;
    }

    public ArrayList getFilaChegada() {
        return filaChegada;
    }

    public void setFilaChegada(ArrayList filaChegada) {
        this.filaChegada = filaChegada;
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

    public double getClientesAtendidos() {
        return clientesAtendidos;
    }

    public void setClientesAtendidos(double clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }

    public double getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(double valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public double getChegada() {
        return chegada;
    }

    public void setChegada(double chegada) {
        this.chegada = chegada;
    }
}