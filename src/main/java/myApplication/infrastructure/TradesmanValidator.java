package myApplication.infrastructure;

import myApplication.domain.Tradesman;

public class TradesmanValidator {

    public TradesmanValidator() {
    }

    public Boolean VerifyData(Tradesman tradesman){
        if ( tradesman.getFirstName() != "" &&
                tradesman.getLastName() != "" &&
                tradesman.getBirthdate() != "" ){
            return true;
        }
        return false;
    }
}
