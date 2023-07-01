import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private Integer statusServidor;
    private Integer numeroEmFila;
    private ArrayList filaChegada;
    private Integer tempoUltimoEvento;
    private Integer relogioSimulacao;
    private Long proximaSaida;
    private Boolean fimSimulacao;
    private String proximoEvento;
    private Integer areaSobQuantidade;
    private Integer areaSobOcupacao;
    private Integer clientesAtendidos;
    private Integer valorAnterior;

    public Servidor(Integer statusServidor, Integer numeroEmFila, ArrayList filaChegada, Integer tempoUltimoEvento, Integer relogioSimulacao, Long proximaSaida, Boolean fimSimulacao, String proximoEvento, Integer areaSobQuantidade, Integer areaSobOcupacao, Integer clientesAtendidos, Integer valorAnterior) {
        this.statusServidor = statusServidor;
        this.numeroEmFila = numeroEmFila;
        this.filaChegada = filaChegada;
        this.tempoUltimoEvento = tempoUltimoEvento;
        this.relogioSimulacao = relogioSimulacao;
        this.proximaSaida = proximaSaida;
        this.fimSimulacao = fimSimulacao;
        this.proximoEvento = proximoEvento;
        this.areaSobQuantidade = areaSobQuantidade;
        this.areaSobOcupacao = areaSobOcupacao;
        this.clientesAtendidos = clientesAtendidos;
        this.valorAnterior = valorAnterior;
    }

    public Integer getStatusServidor() {
        return statusServidor;
    }

    public Integer getNumeroEmFila() {
        return numeroEmFila;
    }

    public ArrayList getFilaChegada() {
        return filaChegada;
    }

    public Integer getTempoUltimoEvento() {
        return tempoUltimoEvento;
    }

    public Integer getRelogioSimulacao() {
        return relogioSimulacao;
    }

    public Long getProximaSaida() {
        return proximaSaida;
    }

    public Boolean getFimSimulacao() {
        return fimSimulacao;
    }

    public String getProximoEvento() {
        return proximoEvento;
    }

    public Integer getAreaSobQuantidade() {
        return areaSobQuantidade;
    }

    public Integer getAreaSobOcupacao() {
        return areaSobOcupacao;
    }

    public Integer getClientesAtendidos() {
        return clientesAtendidos;
    }

    public Integer getValorAnterior() {
        return valorAnterior;
    }
}