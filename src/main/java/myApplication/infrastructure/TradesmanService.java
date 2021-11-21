package myApplication.infrastructure;

import myApplication.domain.Tradesman;
import myApplication.domain.UserRepository;

public class TradesmanService {

    private UserRepository userRepository;
    private TradesmanValidator tradesmanValidator;

    private TradesmanService(UserRepository userRepository, TradesmanValidator tradesmanValidator) {
        this.userRepository = userRepository;
        this.tradesmanValidator = tradesmanValidator;
    }

    public static TradesmanService of(UserRepository userRepository, TradesmanValidator tradesmanValidator) {
        return new TradesmanService(userRepository, tradesmanValidator);
    }

    public void SaveTradesman( Tradesman tradesman){
        tradesman.setId( this.userRepository.nextId() );
        this.userRepository.save( tradesman );
        tradesman.setValidate( true );
    }

    public TradesmanValidator getTradesmanValidator() {
        return tradesmanValidator;
    }
}
