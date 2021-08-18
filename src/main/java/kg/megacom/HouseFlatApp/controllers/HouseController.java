package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.inputs.InputHouseData;
import kg.megacom.HouseFlatApp.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @PostMapping("/save-house")
    public ResponseEntity<HouseDto> save(@RequestBody InputHouseData inputHouseData){
        return new ResponseEntity<>(houseService.saveHouse(inputHouseData), HttpStatus.CREATED);
    }
}
