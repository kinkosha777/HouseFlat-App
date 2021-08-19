package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.ReserveHistoryDto;
import kg.megacom.HouseFlatApp.models.inputs.InputReserveHistoryData;
import kg.megacom.HouseFlatApp.services.ReserveHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ReserveHistoryController {
    @Autowired
    private ReserveHistoryService reserveHistoryService;

    @PostMapping("/save-reserve")
    public ResponseEntity<ReserveHistoryDto> save(@RequestBody InputReserveHistoryData inputReserveHistoryData){
        return new ResponseEntity<>(reserveHistoryService.save(inputReserveHistoryData), HttpStatus.CREATED);
    }
}
