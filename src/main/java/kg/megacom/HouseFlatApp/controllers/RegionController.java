package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.RegionDto;
import kg.megacom.HouseFlatApp.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @PostMapping("save-region")
    public ResponseEntity<RegionDto> save(@RequestBody RegionDto regionDto){
        return new ResponseEntity<>(regionService.saveRegion(regionDto), HttpStatus.CREATED);
    }
}
