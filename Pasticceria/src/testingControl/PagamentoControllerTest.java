package testingControl;

import org.junit.Before;
import org.junit.Test;

import control.PagamentoController;

public class PagamentoControllerTest {
    private PagamentoController pagamentoController;
    private PagamentoIFStub pagamentoIF;
    private VisualizzaOrdineIFStub visualizzaOrdineIF;
    private OrdineStandardStub carrello;
    private OrdineStub ordine;
    private LoginIFStub loginIF;

    @Before
    public void setUp() {
        pagamentoIF = new PagamentoIFStub();
        visualizzaOrdineIF = new VisualizzaOrdineIFStub();
        carrello = new OrdineStandardStub();
        ordine = new OrdineStub();
        loginIF = new LoginIFStub();

        pagamentoController = new PagamentoController(null, pagamentoIF, visualizzaOrdineIF, carrello, ordine, loginIF);
    }

    @Test
    public void testPagamentoStandard() {
        // Simuliamo l'input dell'utente per il pagamento standard
        pagamentoIF.setNumeroCartaField("1234 5678 9012 3456");
        pagamentoIF.setDataScadenzaField("12/25");
        loginIF.setClientePremiumRadioButton(false);

        // Simuliamo il successo del processo di pagamento
        pagamentoIF.setProcessoPagamentoResult(true);

        // Eseguiamo l'azione di pagamento
        pagamentoController.pagamentostandard.actionPerformed(null);

        // Verifichiamo che il carrello sia stato svuotato
        assertTrue(carrello.svuotaCarrelloChiamato);

        // Verifichiamo che il messaggio di pagamento confermato sia stato mostrato
        assertTrue(pagamentoIF.disposeChiamato);
    }

    @Test
    public void testPagamentoStandardFallito() {
        // Simuliamo l'input dell'utente per il pagamento standard
        pagamentoIF.setNumeroCartaField("1234 5678 9012 3456");
        pagamentoIF.setDataScadenzaField("12/25");
        loginIF.setClientePremiumRadioButton(false);

        // Simuliamo il fallimento del processo di pagamento
        pagamentoIF.setProcessoPagamentoResult(false);

        // Eseguiamo l'azione di pagamento
        pagamentoController.pagamentostandard.actionPerformed(null);

        // Verifichiamo che il carrello non sia stato svuotato
        assertFalse(carrello.svuotaCarrelloChiamato);

        // Verifichiamo che il messaggio di pagamento fallito sia stato mostrato
        assertTrue(pagamentoIF.disposeChiamato);
    }

    @Test
    public void testPagamentoPersonalizzato() {
        // Simuliamo l'input dell'utente per il pagamento personalizzato
        pagamentoIF.setNumeroCartaField("1234 5678 9012 3456");
        pagamentoIF.setDataScadenzaField("12/25");
        loginIF.setClientePremiumRadioButton(false);

        // Simuliamo il successo del processo di pagamento
        pagamentoIF.setProcessoPagamentoResult(true);

        // Eseguiamo l'azione di pagamento
        pagamentoController.pagamentoOrdinePersonalizzato.actionPerformed(null);

        // Verifichiamo che il messaggio di pagamento confermato sia stato mostrato
        assertTrue(pagamentoIF.disposeChiamato);
    }

    // Stub per PagamentoIF
    private static class PagamentoIFStub extends PagamentoIF {
        private String numeroCartaField;
        private String dataScadenzaField;
        private boolean processoPagamentoResult;
        public boolean disposeChiamato;

        public void setNumeroCartaField(String numeroCarta) {
            this.numeroCartaField = numeroCarta;
        }

        public void setDataScadenzaField(String dataScadenza) {
            this.dataScadenzaField = dataScadenza;
        }

        public void setProcessoPagamentoResult(boolean result) {
            this.processoPagamentoResult = result;
        }

        @Override
        public String getNumeroCartaField() {
            return numeroCartaField;
        }

        @Override
        public String getDataScadenzaField() {
            return dataScadenzaField;
        }

        @Override
        public boolean processoPagamento(String numeroCarta, String dataScadenza, double importo) {
            return processoPagamentoResult;
        }

        @Override
        public void dispose() {
            disposeChiamato = true;
        }
    }

    // Stub per VisualizzaOrdineIF
    private static class VisualizzaOrdineIFStub extends VisualizzaOrdineIF {
        // Implementazione personalizzata se necessario
    }

    // Stub per OrdineStandard
    private
