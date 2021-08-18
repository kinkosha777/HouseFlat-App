package kg.megacom.HouseFlatApp.models.entities;

import kg.megacom.HouseFlatApp.enums.CodeStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@Table(name = "codes")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private CodeStatus codeStatus;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
