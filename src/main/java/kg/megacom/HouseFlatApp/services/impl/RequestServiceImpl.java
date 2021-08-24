package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.RequestRepo;
import kg.megacom.HouseFlatApp.mappers.RequestMapper;
import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.RequestDto;
import kg.megacom.HouseFlatApp.models.inputs.InputRequestData;
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
    public RequestDto save(RequestDto requestDto) {
        return requestMapper.toDto(requestRepo.save(requestMapper.toEntity(requestDto)));
    }

    @Override
    public long countAllByCodeIdAndSuccess(Long code_id, boolean success) {
        return requestRepo.countAllByCodeIdAndSuccess(code_id,success);
    }
    @Override
    public boolean sendRequest(CodeDto codeDto, boolean status){
        RequestDto requestDto = new RequestDto();
        requestDto.setSuccess(status);
        requestDto.setCode(codeDto);
        requestDto = save(requestDto);
        return requestDto.isSuccess();
    }


}
