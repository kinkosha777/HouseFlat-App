package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.UserDto;
import kg.megacom.HouseFlatApp.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper extends BaseMapper<UserDto, User> {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
}
