package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.HouseRepo;
import kg.megacom.HouseFlatApp.mappers.HouseMapper;
import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.entities.District;
import kg.megacom.HouseFlatApp.models.entities.House;
import kg.megacom.HouseFlatApp.models.inputs.InputHouseData;
import kg.megacom.HouseFlatApp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        houseDto.setFurniture(inputHouseData.isFurniture());
        houseDto.setInternet(inputHouseData.isInternet());
        houseDto.setLat(inputHouseData.getLat());
        houseDto.setLon(inputHouseData.getLon());
        houseDto.setPrice(inputHouseData.getPrice());
        houseDto.setRooms(inputHouseData.getRoom());
        houseDto.setDescriptions(inputHouseData.getDescription());
        if (inputHouseData.getPrice()<=0){
            throw new RuntimeException("Пожалуйста введите положительную цену!");
        }
        return houseMapper.toDto(houseRepo.save(houseMapper.toEntity(houseDto)));
    }

    @Override
    public HouseDto findHouseById(Long id) {
        House house = houseRepo.findById(id).orElseThrow(()-> new RuntimeException("Дом по айди не найден!"));
        return houseMapper.toDto(house);
    }

    @Override
    public List<HouseDto> findHouseByDistrictId(Long id) {
        return houseMapper.toDtoList(houseRepo.findHouseByDistrictId(id));
    }

    @Override
    public List<HouseDto> findHouseByCityId(Long id) {
        return houseMapper.toDtoList(houseRepo.findHouseByCityVillageId(id));
    }



    @Override
    public List<HouseDto> findHouseByTypeId(Long id) {
        return houseMapper.toDtoList(houseRepo.findHouseByTypeId(id));
    }

    @Override
    public List<HouseDto> findHouseByFloor(int floor) {
        return houseMapper.toDtoList(houseRepo.findHouseByFloor(floor));
    }

    @Override
    public List<HouseDto> findHouseByRoom(int floor) {
        return houseMapper.toDtoList(houseRepo.findHouseByRooms(floor));
    }

    @Override
    public List<HouseDto> findHouseByInternet(boolean internet) {
        return houseMapper.toDtoList(houseRepo.findHouseByInternet(internet));
    }

    @Override
    public List<HouseDto> findHouseByFurniture(boolean furniture) {
        return houseMapper.toDtoList(houseRepo.findHouseByFurniture(furniture));
    }

//    @Override
//    public List<HouseDto> findHouseByInternet(boolean internet) {
//        return houseMapper.toDtoList(houseRepo.findHouseByInternet(internet));
//    }
//
//    @Override
//    public List<HouseDto> findHouseByFurniture(Long id) {
//        return houseMapper.toDtoList(houseRepo.findHouseByFurniture(id));
//    }


}
