package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class CodeNotFound extends RuntimeException {
    public CodeNotFound(String message) {
        super(message);
    }
}
