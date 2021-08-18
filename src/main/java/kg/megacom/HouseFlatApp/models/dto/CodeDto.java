package kg.megacom.HouseFlatApp.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.HouseFlatApp.enums.CodeStatus;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CodeDto {
    private Long id;
    private Long code;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate endDate;
    private CodeStatus codeStatus;
    private UserDto user;
}
