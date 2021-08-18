package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.TypeDto;
import kg.megacom.HouseFlatApp.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping("save-type")
    public ResponseEntity<TypeDto> save(@RequestBody TypeDto typeDto){
        return new ResponseEntity<>(typeService.saveType(typeDto), HttpStatus.CREATED);
    }
}
