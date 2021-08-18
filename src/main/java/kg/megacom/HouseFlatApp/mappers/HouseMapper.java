package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.entities.House;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HouseMapper extends BaseMapper<HouseDto, House>{
    HouseMapper HOUSE_MAPPER = Mappers.getMapper(HouseMapper.class);
}
