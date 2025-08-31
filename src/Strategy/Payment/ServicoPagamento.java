package Strategy.Payment;

public class ServicoPagamento {
    public boolean processarPagamento(MetodoPagamento metodo, double valor) {
        return metodo.pagar(valor);
    }
}
