package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.inputs.InputCodeData;
import kg.megacom.HouseFlatApp.models.inputs.InputUserData;
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

    @PostMapping("/save-code")
    public ResponseEntity<CodeDto>  save(@RequestBody InputCodeData inputCodeData){
        return new ResponseEntity<>(codeService.saveCode(inputCodeData), HttpStatus.CREATED);

//    @PutMapping("/chek-code")
//    public ResponseEntity<InputUserData>  chek(@RequestParam long  code_id,@RequestParam long user_code){
//            return new ResponseEntity<>(codeService.chekCode(code_id,user_code),HttpStatus.CREATED);
//        }
    }
}
