package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.DistrictRepo;
import kg.megacom.HouseFlatApp.exceptions.CityVillageNotFound;
import kg.megacom.HouseFlatApp.exceptions.DistrictNotFound;
import kg.megacom.HouseFlatApp.mappers.DistrictMapper;
import kg.megacom.HouseFlatApp.models.dto.CityVillageDto;
import kg.megacom.HouseFlatApp.models.dto.DistrictDto;
import kg.megacom.HouseFlatApp.models.entities.District;
import kg.megacom.HouseFlatApp.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepo districtRepo;

   DistrictMapper districtMapper = DistrictMapper.DISTRICT_MAPPER;

    @Override
    public DistrictDto saveDistrictDto(DistrictDto districtDto) {
        return districtMapper.toDto(districtRepo.save(districtMapper.toEntity(districtDto)));
    }

    @Override
    public DistrictDto findDistrictById(Long id) {
        System.out.println("sasq  "+districtRepo.findById(id));
        District district = districtRepo.findById(id).orElseThrow(()->new DistrictNotFound("Айди Района не найдено!"));
        return districtMapper.toDto(district);
    }

    @Override
    public DistrictDto findCityVillageByID(Long id) {
        CityVillageDto cityVillageDto = new CityVillageDto();
        DistrictDto districtDto = new DistrictDto();
        districtDto.setCityVillage(cityVillageDto);
        District district = districtRepo.findById(id).orElseThrow(()->new CityVillageNotFound("Айди города не найдено!"));
        return districtMapper.toDto(district);
    }
}
