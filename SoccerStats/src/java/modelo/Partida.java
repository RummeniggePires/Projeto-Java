package modelo;

import java.util.Calendar;

public class Partida {
    private int partidaId;
    private int jogadorId;
    private String jogador;
    private double distanciaPercorrida;
    private int golsFeitos;
    private int faltasSofridas;
    private int faltasFeitas;
    private int impedimentos;
    private int assistencias;
    private int cartaoAmarelo;
    private int cartaoVermelho;
    private Calendar dataPartida;
    private boolean escalado;

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public int getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(int partidaId) {
        this.partidaId = partidaId;
    }

    public int getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(int jogadorId) {
        this.jogadorId = jogadorId;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public int getGolsFeitos() {
        return golsFeitos;
    }

    public void setGolsFeitos(int golsFeitos) {
        this.golsFeitos = golsFeitos;
    }

    public int getFaltasSofridas() {
        return faltasSofridas;
    }

    public void setFaltasSofridas(int faltasSofridas) {
        this.faltasSofridas = faltasSofridas;
    }

    public int getFaltasFeitas() {
        return faltasFeitas;
    }

    public void setFaltasFeitas(int faltasFeitas) {
        this.faltasFeitas = faltasFeitas;
    }

    public int getImpedimentos() {
        return impedimentos;
    }

    public void setImpedimentos(int impedimentos) {
        this.impedimentos = impedimentos;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public int getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public void setCartaoAmarelo(int cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    public int getCartaoVermelho() {
        return cartaoVermelho;
    }

    public void setCartaoVermelho(int cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
    }

    public Calendar getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Calendar dataPartida) {
        this.dataPartida = dataPartida;
    }

    public boolean isEscalado() {
        return escalado;
    }

    public void setEscalado(boolean escalado) {
        this.escalado = escalado;
    }
}
