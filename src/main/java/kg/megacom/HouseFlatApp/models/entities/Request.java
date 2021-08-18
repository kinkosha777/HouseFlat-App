package kg.megacom.HouseFlatApp.models.entities;

import kg.megacom.HouseFlatApp.models.entities.Code;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate addDate;
    private boolean success;
    @ManyToOne
    @JoinColumn(name = "codes_id")
    private Code code;
}
