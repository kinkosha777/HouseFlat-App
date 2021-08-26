package kg.megacom.HouseFlatApp.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="+996xxxxxxxxx")
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime blockDate;
}
