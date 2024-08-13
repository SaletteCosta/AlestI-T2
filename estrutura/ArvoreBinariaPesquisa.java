package estrutura;

import gerenciamento.Pedido;

public class ArvoreBinariaPesquisa {
    private Nodo raiz;
    private int tamanho;
    private String caminhoCentral;

    public void adicionar(Pedido pedido) {
        Nodo n = new Nodo(pedido);
        if (raiz == null) {
            raiz = n;
        } else {
            Nodo aux = raiz;
            Nodo paidoAux = null;
            while (aux != null) {
                paidoAux = aux;
                if (pedido.getCodigo() <= aux.getPedido().getCodigo()) {
                    aux = aux.getEsquerda();
                    if (aux == null) {
                        paidoAux.setEsquerda(n);
                    }
                } else {
                    aux = aux.getDireita();
                    if (aux == null) {
                        paidoAux.setDireita(n);
                    }
                }
            }
        }
        tamanho++;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void percorrerEmProfundidade() {
        caminhoCentral = "";
        percorrerEmProfundidade(raiz);
    }
    private void percorrerEmProfundidade(Nodo n) {
        if (n != null) {
            percorrerEmProfundidade(n.getEsquerda());
            caminhoCentral += n.getPedido().getCodigo() + " ";
            percorrerEmProfundidade(n.getDireita());
        }
    }
    public String getCaminhoCentral() {
        return caminhoCentral;
    }
    public String imprimirCodigosArvore() {
        percorrerEmProfundidade();
        return getCaminhoCentral();
    }

}
