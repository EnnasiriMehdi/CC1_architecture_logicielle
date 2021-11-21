package myApplication.infrastructure;

import myApplication.domain.Tradesman;

public class TradesmanController {

    private TradesmanService tradesmanService;
    private PaymentService paymentService;
    private Logger logger;

    private TradesmanController(TradesmanService tradesmanService, PaymentService paymentService, Logger logger) {
        this.tradesmanService = tradesmanService;
        this.paymentService = paymentService;
        this.logger = logger;
    }

    public static TradesmanController of(TradesmanService tradesmanService, PaymentService paymentService, Logger logger){
        return new TradesmanController(tradesmanService, paymentService, logger);
    }

    public void subscribe( Tradesman tradesman){
        if ( tradesmanService.getTradesmanValidator().VerifyData(tradesman) ){
            if( paymentService.ProcessPayment() ){
                this.tradesmanService.SaveTradesman(tradesman);
                this.logger.log("Inscription Réussite");
                return;
            }
            this.logger.log("Une erreur est survenue");
            return;
        }
        this.logger.log("Le formulaire est incomplet ");
    }
}
