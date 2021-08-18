package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.RegionDto;
import kg.megacom.HouseFlatApp.models.entities.Region;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RegionMapper extends BaseMapper<RegionDto, Region>{
    RegionMapper REGION_MAPPER = Mappers.getMapper(RegionMapper.class);
}
