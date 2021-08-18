package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.inputs.InputCodeData;

public interface CodeService {
    CodeDto saveCode(InputCodeData inputCodeData);
    CodeDto findCodeById(Long id);
//    boolean checkCode(Long userId,Long code);
}
