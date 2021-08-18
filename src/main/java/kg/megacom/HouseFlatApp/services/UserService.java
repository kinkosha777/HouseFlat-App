package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.UserDto;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto findUserById(Long id);
}
