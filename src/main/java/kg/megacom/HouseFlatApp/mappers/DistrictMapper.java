package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.DistrictDto;
import kg.megacom.HouseFlatApp.models.entities.District;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DistrictMapper extends BaseMapper<DistrictDto, District> {
    DistrictMapper DISTRICT_MAPPER = Mappers.getMapper(DistrictMapper.class);
}
