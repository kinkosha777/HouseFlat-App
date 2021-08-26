package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class PleasePutPositivePrice extends RuntimeException {
    public PleasePutPositivePrice(String message) {
        super(message);
    }
}
