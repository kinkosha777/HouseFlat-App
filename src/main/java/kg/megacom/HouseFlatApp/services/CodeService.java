package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.enums.CodeStatus;
import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.UserDto;

public interface CodeService {

    CodeDto save(CodeDto codeDto);
    CodeDto findCodeById(Long id);
    boolean sendCode(UserDto userDtoSaved);
    boolean putCode(long code, Long userId);
    boolean updateCode(Long user_id);
    CodeDto findByUserIdAndCodeStatusNot(Long id, CodeStatus codeStatus);
    CodeDto update(CodeDto codeDto);

}
