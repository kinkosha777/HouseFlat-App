package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DistrictNotFound extends RuntimeException {
    public DistrictNotFound(String message) {
        super(message);
    }
}
