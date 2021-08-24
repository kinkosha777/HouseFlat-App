package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.entities.District;
import kg.megacom.HouseFlatApp.models.inputs.InputHouseData;
import kg.megacom.HouseFlatApp.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @PostMapping("/save-house")
    public ResponseEntity<HouseDto> save(@RequestBody InputHouseData inputHouseData){
        return new ResponseEntity<>(houseService.saveHouse(inputHouseData), HttpStatus.CREATED);
    }
    @GetMapping("/findHouseByDistrict")
    public List<HouseDto> findHouseByDistrict(@RequestParam Long id){
        return houseService.findHouseByDistrictId(id);
    }
    @GetMapping("/findHouseByCity")
    public List<HouseDto> findHouseByCity(@RequestParam Long id){
        return houseService.findHouseByCityId(id);
    }

    @GetMapping("/findHouseByType")
    public List<HouseDto> findHouseByType(@RequestParam Long id){
        return houseService.findHouseByTypeId(id);
    }
    @GetMapping("/findHouseByFloor")
    public List<HouseDto> findHouseByFloor(@RequestParam int floor){
        return houseService.findHouseByFloor(floor);
    }
    @GetMapping("/findHouseByRoom")
    public List<HouseDto> findHouseByRoom(@RequestParam int room){
        return houseService.findHouseByRoom(room);
    }
    @GetMapping("/findHouseByInternet")
    public List<HouseDto> findHouseByInternet(@RequestParam boolean internet){
        return houseService.findHouseByInternet(internet);
    }
    @GetMapping("/findHouseByFurniture")
    public List<HouseDto> findHouseByFurniture(@RequestParam boolean furniture){
        return houseService.findHouseByFurniture(furniture);
    }
}
