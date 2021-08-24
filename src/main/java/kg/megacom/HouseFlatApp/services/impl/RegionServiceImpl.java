package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.RegionRepo;
import kg.megacom.HouseFlatApp.mappers.RegionMapper;
import kg.megacom.HouseFlatApp.models.dto.RegionDto;
import kg.megacom.HouseFlatApp.models.entities.Region;
import kg.megacom.HouseFlatApp.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepo regionRepo;

    RegionMapper regionMapper = RegionMapper.REGION_MAPPER;

    @Override
    public RegionDto saveRegion(RegionDto regionDto) {
        return regionMapper.toDto(regionRepo.save(regionMapper.toEntity(regionDto)));
    }

    @Override
    public RegionDto findRegionById(Long id) {
        Region region = regionRepo.findById(id).orElseThrow(()->new RuntimeException("Регион по айди не найден!"));
        return regionMapper.toDto(region);
    }

    @Override
    public List<RegionDto> findRegionByName(String name) {
        return regionMapper.toDtoList(regionRepo.findByName(name));
    }


}
