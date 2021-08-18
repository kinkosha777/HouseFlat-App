package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.UserRepo;
import kg.megacom.HouseFlatApp.mappers.UserMapper;
import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.UserDto;
import kg.megacom.HouseFlatApp.models.entities.User;
import kg.megacom.HouseFlatApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    UserMapper userMapper = UserMapper.USER_MAPPER;
    @Override
    public UserDto saveUser(UserDto userDto) {
        return userMapper.toDto(userRepo.save(userMapper.toEntity(userDto)));
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(()-> new RuntimeException("Пользователь не найден!"));
        return userMapper.toDto(user);
    }


}
