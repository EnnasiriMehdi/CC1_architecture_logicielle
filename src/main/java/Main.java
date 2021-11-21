import distant.StubPayementService;
import myApplication.domain.Tradesman;
import myApplication.infrastructure.*;

public class Main {

    public static void main(String arg []){

        Logger logger = new Logger();
        TradesmanValidator tradesmanValidator = new TradesmanValidator();
        TradesmanService tradesmanService = TradesmanService.of(new InMemoryUserRepository(), tradesmanValidator);
        StubPayementService distantPayementService = StubPayementService.of(logger);
        PaymentService paymentService = PaymentService.of(distantPayementService, logger);
        TradesmanController tradesmanController = TradesmanController.of(tradesmanService, paymentService, logger);

        Tradesman tradesman = Tradesman.of("Test", "Testb", "22-09-1997");
        Tradesman tradesman2 = Tradesman.of("", "Testb", "22-09-1997");
        tradesmanController.subscribe(tradesman);
        tradesmanController.subscribe(tradesman2);

    }
}
