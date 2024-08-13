package gerenciamento;
import estrutura.*;

public class Pizzaria {
    private Pedido pedidoAtual;
    private FilaPedidosDinamica listaPedido;
    private int tempoTotal;
    private ArvoreBinariaPesquisa abp;
    public Pizzaria(ArvoreBinariaPesquisa abp){
        this.pedidoAtual = null;
        this.listaPedido = new FilaPedidosDinamica();
        this.tempoTotal = 0;
        this.abp = abp;

    }
    public void adicionarPedido(Pedido p) {
        if (pedidoAtual == null) {
            pedidoAtual = p;
        } else {
            listaPedido.enfileirar(p);
        }
    }
    public void setPedidoAtual(Pedido pedidoAtual) {
        this.pedidoAtual = pedidoAtual;
    }
    public void processarPedido() {
        if (pedidoAtual != null) {
            pedidoAtual.setTempoPreparo(pedidoAtual.getTempoPreparo() - 1);
            if (pedidoAtual.getTempoPreparo() <= 0) {
                abp.adicionar(pedidoAtual);
                pedidoAtual = null;
            }
        }
    }
    public boolean pizzaioloDisponivel() {
        return pedidoAtual == null;
    }
    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }
    public ArvoreBinariaPesquisa getPedidosProntos() {
        return abp;
    }
    public int totalPedidos(){
        return abp.getTamanho();
    }
}
