package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.RequestDto;
import kg.megacom.HouseFlatApp.models.entities.Request;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RequestMapper extends BaseMapper<RequestDto, Request> {
    RequestMapper REQUEST_MAPPER = Mappers.getMapper(RequestMapper.class);
}
