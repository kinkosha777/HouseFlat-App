package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.TypeDto;
import kg.megacom.HouseFlatApp.models.entities.Type;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface TypeMapper extends BaseMapper<TypeDto, Type>{
    TypeMapper TYPE_MAPPER = Mappers.getMapper(TypeMapper.class);
}
