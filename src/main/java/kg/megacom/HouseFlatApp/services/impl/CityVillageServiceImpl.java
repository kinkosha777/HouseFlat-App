package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.CityVillageRepo;
import kg.megacom.HouseFlatApp.exceptions.CityNotFound;
import kg.megacom.HouseFlatApp.mappers.CityVillageMapper;
import kg.megacom.HouseFlatApp.models.dto.CityVillageDto;
import kg.megacom.HouseFlatApp.models.entities.CityVillage;
import kg.megacom.HouseFlatApp.services.CityVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityVillageServiceImpl implements CityVillageService {
    @Autowired
    private CityVillageRepo cityVillageRepo;

     CityVillageMapper cityVillageMapper = CityVillageMapper.CITY_VILLAGE_MAPPER;

    @Override
    public CityVillageDto saveCityVillage(CityVillageDto cityVillageDto) {
        return cityVillageMapper.toDto(cityVillageRepo.save(cityVillageMapper.toEntity(cityVillageDto)));
    }

    @Override
    public CityVillageDto findCityVillageById(Long id) {
        CityVillage cityVillage = cityVillageRepo.findById(id).orElseThrow(()-> new CityNotFound("Айди города не найден!"));
        return cityVillageMapper.toDto(cityVillage);
    }
}
