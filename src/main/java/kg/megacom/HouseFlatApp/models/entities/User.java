package kg.megacom.HouseFlatApp.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^((\\+?996)([0-9]{9}))$")
    @NotEmpty(message = "Поле Телефон не может быть пустым!")
    private String phone;
    private LocalDateTime blockDate;
}
