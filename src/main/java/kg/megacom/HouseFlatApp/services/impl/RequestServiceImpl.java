package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.RequestRepo;
import kg.megacom.HouseFlatApp.enums.CodeStatus;
import kg.megacom.HouseFlatApp.mappers.RequestMapper;
import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.RequestDto;
import kg.megacom.HouseFlatApp.models.inputs.InputRequestData;
import kg.megacom.HouseFlatApp.models.inputs.InputUserData;
import kg.megacom.HouseFlatApp.services.CodeService;
import kg.megacom.HouseFlatApp.services.RequestService;
import kg.megacom.HouseFlatApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    CodeService codeService;
    @Autowired
    UserService userService;
   RequestMapper requestMapper = RequestMapper.REQUEST_MAPPER;
    @Override
    public RequestDto saveRequest(InputRequestData inputRequestData) {
        RequestDto requestDto = new RequestDto();
        requestDto.setSuccess(true);
        requestDto.setCode(codeService.findCodeById(inputRequestData.getCodeId()));
        return requestMapper.toDto(requestRepo.save(requestMapper.toEntity(requestDto)));
    }

    @Override
    public InputUserData chekCode(Long user_id, Long userCode) {
        CodeDto  codeDto = new CodeDto();
        RequestDto requestDto = new RequestDto();
        if (userCode == 0){
            throw new RuntimeException("код не может быть пустым");

        }else if (userCode != (codeDto.getCode())){
            codeDto.setCodeStatus(CodeStatus.FAILED);

        }
        {
            requestDto.setSuccess(true);
            InputUserData inputUserData = new InputUserData();
            codeDto.setCode(inputUserData.getUserCode());
            codeDto.setUser(userService.findUserById(inputUserData.getUserId()));
        }
        requestDto.setSuccess(true);
        InputUserData inputUserData = new InputUserData();
        codeDto.setCode(inputUserData.getUserCode());
        codeDto.setUser(userService.findUserById(inputUserData.getUserId()));
            throw new RuntimeException("код не правильный");
    }



}
