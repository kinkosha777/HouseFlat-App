package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.inputs.InputCodeData;
import kg.megacom.HouseFlatApp.models.inputs.InputUserData;

public interface CodeService {
    CodeDto saveCode(InputCodeData inputCodeData);
    CodeDto findCodeById(Long id);
    InputUserData chekCode(long code_id, long user_code);
    CodeDto saveForCode(CodeDto codeDto);
}
