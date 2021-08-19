package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.inputs.InputHouseData;

public interface HouseService {

    HouseDto saveHouse(InputHouseData inputHouseData);
    HouseDto findHouseById(Long id);

}
