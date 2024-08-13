package estrutura;

import gerenciamento.Pedido;

public class Nodo {
    private Pedido pedido;
    private Nodo proximo;
    private Nodo esquerda;
    private Nodo direita;
    private Nodo pai;

    public Nodo(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public Nodo getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Nodo esquerda) {
        this.esquerda = esquerda;
    }

    public Nodo getDireita() {
        return direita;
    }

    public void setDireita(Nodo direita) {
        this.direita = direita;
    }

    public Nodo getPai() {
        return pai;
    }

    public void setPai(Nodo pai) {
        this.pai = pai;
    }
}