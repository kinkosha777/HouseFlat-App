package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.PayHistoryDto;

import java.util.List;

public interface PayHistoryService {
    PayHistoryDto savePay(PayHistoryDto payHistoryDto);
    PayHistoryDto findPayHistoryById(Long id);
    List<PayHistoryDto> findByReserveHistoryId(Long reserve_id);
}
