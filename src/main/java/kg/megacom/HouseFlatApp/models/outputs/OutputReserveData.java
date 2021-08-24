package kg.megacom.HouseFlatApp.models.outputs;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.HouseFlatApp.enums.ReserveStatus;
import lombok.Data;

import java.time.LocalDate;
@Data
public class OutputReserveData {
    private Long houseId;
    private Long customerId;
    private Long reserveId;
    private ReserveStatus reserveStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate endDate;
    private double totalPrice;
    private double cash;
}
