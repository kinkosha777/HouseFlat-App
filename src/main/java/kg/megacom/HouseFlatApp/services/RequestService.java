package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.CodeDto;
import kg.megacom.HouseFlatApp.models.dto.RequestDto;
import kg.megacom.HouseFlatApp.models.inputs.InputRequestData;

public interface RequestService {
    RequestDto saveRequest(InputRequestData inputRequestData);

    RequestDto save(RequestDto requestDto);

    long countAllByCodeIdAndSuccess(Long code_id, boolean success);

    boolean sendRequest(CodeDto codeDto, boolean status);
}
