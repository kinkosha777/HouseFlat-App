package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.CityVillageDto;
import kg.megacom.HouseFlatApp.services.CityVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cityVillage")
public class CityVillageController {
    @Autowired
    private CityVillageService cityVillageService;

    @PostMapping("save-cityVillage")
    public ResponseEntity<CityVillageDto>  save(@RequestBody CityVillageDto cityVillageDto){
        return new ResponseEntity<>(cityVillageService.saveCityVillage(cityVillageDto), HttpStatus.CREATED);
    }
}
