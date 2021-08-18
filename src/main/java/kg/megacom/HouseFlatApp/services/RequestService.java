package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.RequestDto;
import kg.megacom.HouseFlatApp.models.inputs.InputRequestData;
import kg.megacom.HouseFlatApp.models.inputs.InputUserData;

public interface RequestService {
    RequestDto saveRequest(InputRequestData inputRequestData);

    InputUserData chekCode(Long user_id,Long userCode);

}
