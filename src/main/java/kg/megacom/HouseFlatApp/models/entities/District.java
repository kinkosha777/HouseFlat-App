package kg.megacom.HouseFlatApp.models.entities;

import kg.megacom.HouseFlatApp.models.entities.CityVillage;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "city_villages_id")
    private CityVillage cityVillage;
    private String name;

}
