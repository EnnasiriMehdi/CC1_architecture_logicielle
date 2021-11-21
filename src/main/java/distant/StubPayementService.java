package distant;

import myApplication.infrastructure.Logger;

public class StubPayementService {

    public Logger logger;

    private StubPayementService(Logger logger) {
        this.logger = logger;
    }

    public static StubPayementService of(Logger logger) {
        return new StubPayementService(logger);
    }

    public boolean ProcessPaiement(){
        return true;
    }

}
