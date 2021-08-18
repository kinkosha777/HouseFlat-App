package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.CityVillageDto;

public interface CityVillageService {
    CityVillageDto saveCityVillage(CityVillageDto cityVillageDto);
    CityVillageDto findCityVillageById(Long id);
}
