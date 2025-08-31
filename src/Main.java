import Facade.*;
import Singleton.*;
import Strategy.Payment.*;

public class Main {
    public static void main(String[] args) {
        // Usando o Singleton para pegar uma configuração
        ConfigManager config = ConfigManager.getInstance();
        System.out.println("URL do Banco de Dados: " + config.getProperty("db.url"));

        // O cliente interage apenas com a Facade
        PedidoFacade pedidoFacade = new PedidoFacade();

        // Cliente decide usar Cartão de Crédito (Strategy)
        MetodoPagamento cartao = new PagamentoCartaoCredito("1234-5678-9012-3456");

        // Realiza o pedido através da interface simples
        pedidoFacade.realizarPedido("PROD-001", 2, "cliente@email.com", cartao);

        System.out.println("\n-----------------------------\n");

        // Outro cliente decide usar Pix (outra Strategy)
        MetodoPagamento pix = new PagamentoPix("cliente@email.com");
        pedidoFacade.realizarPedido("PROD-002", 1, "outrocliente@email.com", pix);
    }
}