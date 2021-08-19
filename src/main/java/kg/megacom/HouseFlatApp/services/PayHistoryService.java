package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.PayHistoryDto;

public interface PayHistoryService {
    PayHistoryDto savePay(PayHistoryDto payHistoryDto);
    PayHistoryDto findPayHistoryById(Long id);
}
