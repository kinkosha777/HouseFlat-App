package kg.megacom.HouseFlatApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
public class PaymentFailed extends RuntimeException {
    public PaymentFailed(String message) {
        super(message);
    }
}
