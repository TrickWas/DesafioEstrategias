package Facade;

import Strategy.Inventory.*;
import Strategy.Notification.*;
import Strategy.Payment.ServicoPagamento;
import Strategy.Payment.MetodoPagamento;

public class PedidoFacade {
    private ServicoInventario servicoInventario;
    private ServicoPagamento servicoPagamento;
    private ServicoNotificacao servicoNotificacao;

    public PedidoFacade() {
        this.servicoInventario = new ServicoInventario();
        this.servicoPagamento = new ServicoPagamento();
        this.servicoNotificacao = new ServicoNotificacao();
    }

    public boolean realizarPedido(String produtoId, int quantidade, String emailCliente, MetodoPagamento metodoPagamento) {
        System.out.println("Iniciando processo de pedido...");

        if (!servicoInventario.verificarEstoque(produtoId, quantidade)) {
            System.out.println("Produto fora de estoque.");
            return false;
        }

        double valorTotal = 250.0; // Valor calculado
        if (!servicoPagamento.processarPagamento(metodoPagamento, valorTotal)) {
            System.out.println("Falha no pagamento.");
            return false;
        }

        servicoNotificacao.enviarEmailConfirmacao(emailCliente);

        System.out.println("Pedido realizado com sucesso!");
        return true;
    }
}
