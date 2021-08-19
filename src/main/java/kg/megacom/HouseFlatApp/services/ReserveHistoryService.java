package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.ReserveHistoryDto;
import kg.megacom.HouseFlatApp.models.inputs.InputReserveHistoryData;
import kg.megacom.HouseFlatApp.models.outputs.OutputReserveData;

import java.util.List;

public interface ReserveHistoryService {
    ReserveHistoryDto saveReserve(ReserveHistoryDto reserveHistoryDto);
    ReserveHistoryDto save(InputReserveHistoryData inputReserveHistoryData);
    ReserveHistoryDto findReserveById(Long id);
    OutputReserveData doOperation(List<ReserveHistoryDto> reserveHistoryDtoList, Long id);
    OutputReserveData pay(Long user_id, double cash);




}
