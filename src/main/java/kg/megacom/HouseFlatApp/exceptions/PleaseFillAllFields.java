package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class PleaseFillAllFields extends RuntimeException{
    public PleaseFillAllFields(String message) {
        super(message);
    }
}
