package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.DistrictDto;

public interface DistrictService {
    DistrictDto saveDistrictDto (DistrictDto districtDto);
    DistrictDto findDistrictById(Long id);
    DistrictDto findCityVillageByID(Long id);
}
