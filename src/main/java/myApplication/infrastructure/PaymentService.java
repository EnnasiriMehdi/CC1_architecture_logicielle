package myApplication.infrastructure;

import distant.StubPayementService;

public class PaymentService {

    private StubPayementService url;
    private Logger logger;

    private PaymentService(StubPayementService url, Logger logger) {
        this.url = url;
        this.logger = logger;
    }

    public static PaymentService of(StubPayementService url, Logger logger) {
       return new PaymentService(url, logger);
    }

    public boolean ProcessPayment(){
        this.logger.log("Paiement accepté !");
        return this.url.ProcessPaiement();
    }

    public StubPayementService getUrl() {
        return url;
    }

    public void setUrl(StubPayementService url) {
        this.url = url;
    }
}
