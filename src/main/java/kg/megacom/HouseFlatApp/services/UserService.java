package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.RequestDto;
import kg.megacom.HouseFlatApp.models.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserDto save(UserDto userDto);
    UserDto findUserById(Long id);
    UserDto getOrCreate(UserDto userDto);
    UserDto update(UserDto userDto);
    UserDto findById(Long id);
}
