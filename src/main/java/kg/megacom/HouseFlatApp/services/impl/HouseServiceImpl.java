package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.HouseRepo;
import kg.megacom.HouseFlatApp.mappers.HouseMapper;
import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.inputs.InputHouseData;
import kg.megacom.HouseFlatApp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepo houseRepo;
    @Autowired
    private TypeService typeService;
    @Autowired
    private UserService userService;
    @Autowired
    private CityVillageService cityVillageService;
    @Autowired
    private DistrictService districtService;
    HouseMapper houseMapper = HouseMapper.HOUSE_MAPPER;

    @Override
    public HouseDto saveHouse(InputHouseData inputHouseData) {
        HouseDto houseDto = new HouseDto();
        houseDto.setAddress(inputHouseData.getAddress());
        houseDto.setArea(inputHouseData.getArea());
        houseDto.setCityVillage(cityVillageService.findCityVillageById(inputHouseData.getCityVillageId()));
        houseDto.setType(typeService.findTypeById(inputHouseData.getTypeId()));
        houseDto.setUser(userService.findUserById(inputHouseData.getOwnerUserId()));
        houseDto.setDistrict(districtService.findDistrictById(inputHouseData.getDistrictId()));
        houseDto.setFloor(inputHouseData.getFloor());
        houseDto.setFurniture(inputHouseData.getFurniture());
        houseDto.setInternet(inputHouseData.getInternet());
        houseDto.setLat(inputHouseData.getLat());
        houseDto.setLon(inputHouseData.getLon());
        houseDto.setPrice(inputHouseData.getPrice());
        houseDto.setRooms(inputHouseData.getRoom());
        return houseMapper.toDto(houseRepo.save(houseMapper.toEntity(houseDto)));
    }
}
