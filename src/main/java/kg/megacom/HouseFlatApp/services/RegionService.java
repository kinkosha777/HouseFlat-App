package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.RegionDto;

import java.util.List;

public interface RegionService {
    RegionDto saveRegion(RegionDto regionDto);
    RegionDto findRegionById(Long id);
    List<RegionDto> findRegionByName( String name);
}
