package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class CodeApproved extends RuntimeException {
    public CodeApproved(String message) {
        super(message);
    }
}
