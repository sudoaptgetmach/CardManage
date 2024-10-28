package org.mach.superclass;

public class Compra implements Comparable<Compra> {

    private String descricao;
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return this.getDescricao() + " - " + String.format("%.2f", this.getValor());
    }

    @Override
    public int compareTo(Compra c) {
        return Double.compare(this.getValor(), c.getValor());
    }
}