package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.CityVillageDto;
import kg.megacom.HouseFlatApp.models.entities.CityVillage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CityVillageMapper extends BaseMapper<CityVillageDto, CityVillage>{
    CityVillageMapper CITY_VILLAGE_MAPPER = Mappers.getMapper(CityVillageMapper.class);
}
