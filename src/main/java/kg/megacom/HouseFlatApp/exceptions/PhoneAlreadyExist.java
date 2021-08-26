package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class PhoneAlreadyExist extends RuntimeException {
    public PhoneAlreadyExist(String message) {
        super(message);
    }
}
