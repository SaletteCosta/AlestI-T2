package estrutura;

import gerenciamento.Pedido;


public class FilaAuxiliar {
    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

    public FilaAuxiliar() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void enfileirar(Pedido pedido) {
        Nodo n = new Nodo(pedido);
        if (tamanho == 0) {
            inicio = n;
            fim = n;
        } else {
            fim.setProximo(n);
            fim = n;
        }
        tamanho++;
    }

    public Pedido desenfileirar() {
        if (tamanho > 0) {
            Pedido aux = inicio.getPedido();
            inicio = inicio.getProximo();
            tamanho--;
            return aux;
        }
        return null;
    }
    public boolean filaAuxEstaVazia() {
        return inicio == null;
    }
    public Pedido getInicio(){
        return inicio.getPedido();
    }
}