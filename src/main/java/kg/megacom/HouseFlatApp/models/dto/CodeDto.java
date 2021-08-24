package kg.megacom.HouseFlatApp.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.HouseFlatApp.enums.CodeStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CodeDto {
    private Long id;
    private Long code;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CodeStatus codeStatus;
    private UserDto user;
}
