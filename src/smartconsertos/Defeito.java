/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartconsertos;

/**
 *
 * @author Bruno Ravadelli
 */
public class Defeito {
    
    private String tipoDefeito;
    private String descricao;
    private double valorConserto;
    private int tempoDeConserto;

    public Defeito(String tipoDefeito, String descricao, double valorConserto, int tempoDeConserto) {
        this.tipoDefeito = tipoDefeito;
        this.descricao = descricao;
        this.valorConserto = valorConserto;
        this.tempoDeConserto = tempoDeConserto;
    }

    public String getTipoDefeito() {
        return tipoDefeito;
    }

    public void setTipoDefeito(String tipoDefeito) {
        this.tipoDefeito = tipoDefeito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(double valorConserto) {
        this.valorConserto = valorConserto;
    }

    public int getTempoDeConserto() {
        return tempoDeConserto;
    }

    public void setTempoDeConserto(int tempoDeConserto) {
        this.tempoDeConserto = tempoDeConserto;
    }
    
    
    
    
    
}
