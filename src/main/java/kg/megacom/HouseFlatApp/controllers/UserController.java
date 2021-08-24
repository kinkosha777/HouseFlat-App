package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.UserDto;
import kg.megacom.HouseFlatApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save-user")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return new  ResponseEntity<> (userService.save(userDto), HttpStatus.CREATED);
    }
    @PostMapping("/get-or-create")
    public ResponseEntity<UserDto> getOrCreate(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.getOrCreate(userDto),HttpStatus.CREATED);

    }

}
