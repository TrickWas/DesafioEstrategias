package Strategy.Payment;

// com/ecommerce/payment/PagamentoCartaoCredito.java

public class PagamentoCartaoCredito implements MetodoPagamento {
    private String numeroCartao;
    // outros dados do cartão...

    public PagamentoCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean pagar(double quantia) {
        System.out.println("Pagando R$ " + quantia + " com Cartão de Crédito.");
        // Lógica para validar e processar o pagamento com cartão
        return true;
    }
}


