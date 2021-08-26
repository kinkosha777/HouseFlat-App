package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TypeNotFound extends RuntimeException {
    public TypeNotFound(String message) {
        super(message);
    }
}
