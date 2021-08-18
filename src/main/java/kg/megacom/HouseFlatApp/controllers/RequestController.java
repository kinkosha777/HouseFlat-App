package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.RequestDto;
import kg.megacom.HouseFlatApp.models.inputs.InputRequestData;
import kg.megacom.HouseFlatApp.models.inputs.InputUserData;
import kg.megacom.HouseFlatApp.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("save-request")
    public ResponseEntity<RequestDto> save(@RequestBody InputRequestData inputRequestData){
        return new ResponseEntity<>(requestService.saveRequest(inputRequestData), HttpStatus.CREATED);



    }
}
