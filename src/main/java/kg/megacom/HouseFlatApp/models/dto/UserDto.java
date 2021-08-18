package kg.megacom.HouseFlatApp.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDto {
    private Long id;
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate blockDate;
}
