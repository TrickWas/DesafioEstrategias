package Strategy.Payment;

// com/ecommerce/payment/PagamentoPix.java

public class PagamentoPix implements MetodoPagamento {
    private String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean pagar(double quantia) {
        System.out.println("Pagando R$ " + quantia + " com PIX.");
        // Lógica para gerar QR Code e processar o pagamento
        return true;
    }
}