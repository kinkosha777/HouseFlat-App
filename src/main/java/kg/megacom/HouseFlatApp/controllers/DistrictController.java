package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.DistrictDto;
import kg.megacom.HouseFlatApp.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping("/save-district")
    public ResponseEntity<DistrictDto> save(@RequestBody DistrictDto districtDto){
        return new ResponseEntity<>(districtService.saveDistrictDto(districtDto), HttpStatus.CREATED);
    }
}
