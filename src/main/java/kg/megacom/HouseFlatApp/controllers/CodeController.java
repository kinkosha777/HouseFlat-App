package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.inputs.InputCodeData;
import kg.megacom.HouseFlatApp.models.inputs.InputUserData;
import kg.megacom.HouseFlatApp.models.outputs.OutputCodeData;
import kg.megacom.HouseFlatApp.services.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/code")
public class CodeController {
    @Autowired
    private CodeService codeService;


        @PostMapping("/put-code")
        public ResponseEntity<Boolean>  putCode(@RequestParam Long user_id, @RequestParam Long code){
            return new ResponseEntity<>(codeService.putCode(code, user_id), HttpStatus.CREATED);
        }
    @PostMapping("/update-code")
    public ResponseEntity<Boolean> updateCode(@RequestParam Long user_id){
        return new ResponseEntity<>(codeService.updateCode(user_id),HttpStatus.CREATED);
    }
}
