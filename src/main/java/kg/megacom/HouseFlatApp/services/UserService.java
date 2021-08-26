package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.UserDto;

public interface UserService {
    UserDto save(UserDto userDto);
//    UserDto findUserById(Long id);
    UserDto update(UserDto userDto);
    UserDto findById(Long id);
}
