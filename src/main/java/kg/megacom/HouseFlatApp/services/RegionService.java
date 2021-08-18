package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.RegionDto;

public interface RegionService {
    RegionDto saveRegion(RegionDto regionDto);
    RegionDto findRegionById(Long id);
}
