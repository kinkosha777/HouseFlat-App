package kg.megacom.HouseFlatApp.models.dto;

import lombok.Data;

@Data
public class CityVillageDto {
    private Long id;
    private RegionDto region;
    private String name;
}
