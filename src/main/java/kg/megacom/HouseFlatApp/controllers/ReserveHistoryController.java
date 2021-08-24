package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.ReserveHistoryDto;
import kg.megacom.HouseFlatApp.models.inputs.InputReserveHistoryData;
import kg.megacom.HouseFlatApp.models.outputs.OutputReserveData;
import kg.megacom.HouseFlatApp.services.ReserveHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ReserveHistoryController {
    @Autowired
    private ReserveHistoryService reserveHistoryService;

    @PostMapping("/save-reserve")
    public ResponseEntity<ReserveHistoryDto> save(@RequestBody InputReserveHistoryData inputReserveHistoryData){
        return new ResponseEntity<>(reserveHistoryService.save(inputReserveHistoryData), HttpStatus.CREATED);
    }
    @PostMapping("/pay-service")
    public  ResponseEntity<OutputReserveData> pay(@RequestParam Long reserve_id,@RequestParam Long user_id,@RequestParam double cash){
        return  new ResponseEntity<>(reserveHistoryService.pay(reserve_id, user_id, cash),HttpStatus.CREATED);
    }
}
