package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.UserRepo;
import kg.megacom.HouseFlatApp.exceptions.UserNotFound;
import kg.megacom.HouseFlatApp.mappers.UserMapper;
import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.UserDto;
import kg.megacom.HouseFlatApp.models.entities.User;
import kg.megacom.HouseFlatApp.services.CodeService;
import kg.megacom.HouseFlatApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CodeService codeService;
    UserMapper userMapper = UserMapper.USER_MAPPER;
//    @Override
//    public UserDto save(UserDto userDto) {
//        UserDto userDtoSaved = userMapper.toDto(userRepo.save(userMapper.toEntity(userDto)));
//        codeService.sendCode(userDtoSaved);
//        return userDtoSaved;
//    }
//
//    @Override
//    public UserDto findUserById(Long id) {
//        User user = userRepo.findById(id).orElseThrow(()-> new RuntimeException("Пользователь не найден!"));
//        return userMapper.toDto(user);
//    }
//
//    @Override
//    public UserDto getOrCreate(UserDto userDto) {
//        User user = userMapper.toEntity(userDto);
//        try {
//            user = userRepo.findById(user.getId()).orElseThrow(()-> new UserNotFound("Пользователь не найден!"));
//        }catch (UserNotFound e){
//           user = userRepo.save(user);
//        }
//        return userMapper.toDto(user);
//    }
//
//
//
//    @Override
//    public UserDto update(UserDto userDto) {
//        UserDto userDtoSaved = userMapper.toDto(userRepo.save(userMapper.toEntity(userDto)));
//        return userDtoSaved;
//    }
@Override
public UserDto save(UserDto userDto) {
    if(findByPhone(userDto.getPhone())==null) {
        UserDto userDtoSaved = userMapper.toDto(userRepo.save(userMapper.toEntity(userDto)));
        codeService.sendCode(userDtoSaved);
        return userDtoSaved;
    }else {
        throw new RuntimeException("User with this phone already exists!!!");
    }
}

    @Override
    public UserDto findUserById(Long id) {
        return null;
    }

    @Override
    public UserDto getOrCreate(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UserDto userDto) {

        UserDto userDtoSaved = userMapper.toDto(userRepo.save(userMapper.toEntity(userDto)));
        return userDtoSaved;
    }


    public UserDto findById(Long id) {
        User user = userRepo.findById(id).orElseThrow(()-> new RuntimeException("Пользователь не найден!"));
        return userMapper.toDto(user);
    }


    public List<UserDto> findAll() {
        return null;
    }


    public UserDto findByPhone(String phone) {

        return userMapper.toDto(userRepo.findByPhone(phone));
    }


}
