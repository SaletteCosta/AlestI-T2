package estrutura;

import gerenciamento.Pedido;

public class FilaPedidosDinamica {
    private Nodo inicio;
    private Nodo fim;
    private int pedidosPendentes;

    public FilaPedidosDinamica() {
        pedidosPendentes = 0;
        inicio = null;
        fim = null;
    }
    public Nodo getInicio() {
        return inicio;
    }
    public Pedido getPedido() {
        return inicio.getPedido();
    }

    public void enfileirar(Pedido pedido) {
        Nodo n = new Nodo(pedido);
        if (pedidosPendentes == 0) {
            inicio = n;
            fim = n;
        } else {
            fim.setProximo(n);
            fim = n;
        }
        pedidosPendentes++;
    }

    public Pedido desenfileirar() {
        Pedido antigoInicio = null;
        if (pedidosPendentes > 0) {
            antigoInicio = inicio.getPedido();
            inicio = inicio.getProximo();
            pedidosPendentes--;
            return antigoInicio;
        }
        return antigoInicio;
    }

    public int getPedidosPendentes() {
        return pedidosPendentes;
    }

    public String imprimirFila() {
        StringBuilder sb = new StringBuilder();
        Nodo aux = inicio;
        while(aux!=null) {
            sb.append(aux.getPedido().getCodigo()).append(",");
            aux = aux.getProximo();
        }
        return sb.toString();
    }
    public boolean estaVazia() {
        return inicio == null;
    }
}

