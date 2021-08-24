package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.dto.RegionDto;
import kg.megacom.HouseFlatApp.models.entities.District;
import kg.megacom.HouseFlatApp.models.inputs.InputHouseData;

import java.util.List;

public interface HouseService {

    HouseDto saveHouse(InputHouseData inputHouseData);
    HouseDto findHouseById(Long id);
    List<HouseDto> findHouseByDistrictId(Long id);
    List<HouseDto> findHouseByCityId(Long id);
    List<HouseDto> findHouseByTypeId(Long id);
    List<HouseDto> findHouseByFloor(int floor);
    List<HouseDto> findHouseByRoom(int room);
    List<HouseDto> findHouseByInternet(boolean internet);
    List<HouseDto> findHouseByFurniture(boolean furniture);

}
