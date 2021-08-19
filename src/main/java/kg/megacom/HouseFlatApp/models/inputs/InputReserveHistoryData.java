package kg.megacom.HouseFlatApp.models.inputs;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.HouseFlatApp.enums.ReserveStatus;
import lombok.Data;

import java.time.LocalDate;
@Data
public class InputReserveHistoryData {
    private Long houseId;
    private Long customerUser;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate endDate;


}
