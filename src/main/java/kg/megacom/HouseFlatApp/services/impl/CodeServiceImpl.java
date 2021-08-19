package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.CodeRepo;
import kg.megacom.HouseFlatApp.enums.CodeStatus;
import kg.megacom.HouseFlatApp.mappers.CodeMapper;
import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.entities.Code;
import kg.megacom.HouseFlatApp.models.inputs.InputCodeData;
import kg.megacom.HouseFlatApp.models.inputs.InputUserData;
import kg.megacom.HouseFlatApp.services.CodeService;
import kg.megacom.HouseFlatApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeRepo codeRepo;
    @Autowired
    private UserService userService;
     CodeMapper codeMapper = CodeMapper.CODE_MAPPER;
    @Override
    public CodeDto saveCode(InputCodeData inputCodeData) {
        CodeDto codeDto = new CodeDto();
        codeDto.setCode((long) ((Math.random() * (9999 - 1000)) + 1000));
        codeDto.setCodeStatus(CodeStatus.NEW);
        codeDto.setStartDate(inputCodeData.getStartDate());
        codeDto.setEndDate(inputCodeData.getStartDate());
        codeDto.setUser(userService.findUserById(inputCodeData.getUserId()));
        return codeMapper.toDto(codeRepo.save(codeMapper.toEntity(codeDto)));
    }

    @Override
    public CodeDto findCodeById(Long id) {
        Code code = codeRepo.findById(id).orElseThrow(()-> new RuntimeException("Код по айди не найден!"));
        return codeMapper.toDto(code);
    }

    @Override
    public InputUserData chekCode(long code_id, long user_code) {
    if (user_code <=0){
        throw new RuntimeException("Введи номально!");
    }
        CodeDto codeDto = findCodeById(code_id);
    if (codeDto.getCode().equals(user_code)){
        codeDto.setCodeStatus(CodeStatus.APPROVED);
    }
    if (!codeDto.getCode().equals(user_code)){
        codeDto.setCodeStatus(CodeStatus.FAILED);
    }else codeDto.setCodeStatus(CodeStatus.CANCELED);

    codeDto = saveForCode(codeDto);
    InputUserData inputUserData = new InputUserData();
    inputUserData.setCode_id(code_id);
    inputUserData.setUserCode(user_code);

        return inputUserData;
    }

    @Override
    public CodeDto saveForCode(CodeDto codeDto) {
        return codeMapper.toDto(codeRepo.save(codeMapper.toEntity(codeDto)));
    }


}
