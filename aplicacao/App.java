package aplicacao;

import estrutura.*;
import gerenciamento.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    private Scanner entrada;
    private FilaPedidosDinamica filaPedidosDinamica;
    private Pizzaria pizzaria;
    private FilaAuxiliar filaAux;
    private ArvoreBinariaPesquisa abp;
    private PrintStream situacaoFilaSaida;
    private PrintStream situacaoArvore;
    private PrintStream relatorioGeral;

    public App() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("pedidos_pizza_15.csv"));
            entrada = new Scanner(streamEntrada);
            situacaoFilaSaida = new PrintStream(new File("situacao_fila.csv"), StandardCharsets.UTF_8);
            situacaoArvore = new PrintStream(new File("abp_prontos.csv"), StandardCharsets.UTF_8);
            relatorioGeral = new PrintStream(new File("relatorio_geral.csv"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e);
        }
        filaPedidosDinamica = new FilaPedidosDinamica();
        filaAux = new FilaAuxiliar();
        abp = new ArvoreBinariaPesquisa();
        pizzaria = new Pizzaria(abp);
    }
    public void executa() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tempo = 0;
        leitura();
        try {
            situacaoFilaSaida.println("Instante de Tempo t,Fila de pedidos,Em produção,Prontos");
            situacaoArvore.println("Caminhamento central da ABP a cada instante de tempo: ");
            relatorioGeral.println("Relatório Geral: ");
            registraSituacaoGeral(tempo);

            System.out.println("Pressione <ENTER> para a simulação ciclo a ciclo ou <C> para a simulação contínua");

            String teclado = reader.readLine();
            if (teclado.equalsIgnoreCase("C")) {
                while (!simulacaoConcluida()) {
                    System.out.println("Instante: " + tempo);
                    colocaNaFila(tempo);
                    processaCiclo(tempo);
                    registraSituacaoFila(tempo);
                    registraSituacaoArvore();
                    registraSituacaoGeral(tempo);
                    tempo++;
                }
            } else {
                while (!simulacaoConcluida()) {
                    System.out.println("Pressione <ENTER> para avançar um ciclo.");
                    teclado = reader.readLine();
                    if (teclado.isEmpty()) {
                        System.out.println("Instante: " + tempo);
                    }
                    colocaNaFila(tempo);
                    processaCiclo(tempo);
                    registraSituacaoFila(tempo);
                    registraSituacaoArvore();
                    registraSituacaoGeral(tempo);
                    tempo++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            situacaoFilaSaida.close();
            situacaoArvore.close();
            relatorioGeral.close();
        }
    }
    private boolean simulacaoConcluida() {
        return filaAux.filaAuxEstaVazia() && filaPedidosDinamica.getPedidosPendentes() == 0 && pizzaria.getPedidoAtual() == null;
    }
    private void leitura() {
        String linha;
        if (entrada.hasNextLine()) {
            entrada.nextLine();
        }
        while (entrada.hasNextLine()) {
            linha = entrada.nextLine().trim();
            String[] valores = linha.split(",");
            if (valores.length == 4) {
                try {
                    int codigo = Integer.parseInt(valores[0]);
                    String saborPizza = valores[1];
                    int instante = Integer.parseInt(valores[2]);
                    int tempoPreparo = Integer.parseInt(valores[3]);
                    Pedido p = new Pedido(codigo, saborPizza, instante, tempoPreparo);
                    filaAux.enfileirar(p);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private void colocaNaFila(int tempo) {
        while (!filaAux.filaAuxEstaVazia() && filaAux.getInicio().getInstante() == tempo) {
            Pedido p = filaAux.desenfileirar();
            if (filaPedidosDinamica.getPedidosPendentes() == 0 && pizzaria.getPedidoAtual() == null) {
                pizzaria.setPedidoAtual(p);
            } else {
                filaPedidosDinamica.enfileirar(p);
            }
        }
    }
    private void processaCiclo(int tempo) {
        pizzaria.processarPedido();
        if (pizzaria.pizzaioloDisponivel()) {
            if (pizzaria.getPedidoAtual() == null) {
                Pedido proximoPedido = filaPedidosDinamica.desenfileirar();
                if (proximoPedido != null) {
                    pizzaria.adicionarPedido(proximoPedido);
                }
            }
        }
    }
    public void registraSituacaoFila(int tempo) {
        String mensagem = tempo + ", ";
        mensagem += filaPedidosDinamica.imprimirFila();
        if (pizzaria.getPedidoAtual() == null) {
            mensagem += " ";
        } else {
            mensagem += "Pedido atual: " + pizzaria.getPedidoAtual().getCodigo();
            if (pizzaria.getPedidosProntos() == null) {
                mensagem += "";
            } else {
                if (abp != null) {
                    mensagem += " Pedidos prontos: " + abp.imprimirCodigosArvore();
                } else {
                    mensagem += "";
                }
            }
        }
        situacaoFilaSaida.println(mensagem);
    }
    public void registraSituacaoArvore() {
        situacaoArvore.println(abp.imprimirCodigosArvore());
    }
    public void registraSituacaoGeral(int tempo) {
        relatorioGeral.println("Total de pedidos processados: " + pizzaria.totalPedidos());
        relatorioGeral.println("Total de tempo executado: " + tempo);
    }
}
