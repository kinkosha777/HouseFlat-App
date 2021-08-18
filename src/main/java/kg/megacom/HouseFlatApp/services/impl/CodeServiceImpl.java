package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.CodeRepo;
import kg.megacom.HouseFlatApp.enums.CodeStatus;
import kg.megacom.HouseFlatApp.mappers.CodeMapper;
import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.UserDto;
import kg.megacom.HouseFlatApp.models.entities.Code;
import kg.megacom.HouseFlatApp.models.inputs.InputCodeData;
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


}
