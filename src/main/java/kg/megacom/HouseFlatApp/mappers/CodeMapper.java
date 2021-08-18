package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.entities.Code;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CodeMapper extends BaseMapper <CodeDto, Code>{
    CodeMapper CODE_MAPPER = Mappers.getMapper(CodeMapper.class);
}
