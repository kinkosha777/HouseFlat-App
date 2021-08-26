package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DateAlreadyReserve extends RuntimeException {
    public DateAlreadyReserve(String message) {
        super(message);
    }
}
