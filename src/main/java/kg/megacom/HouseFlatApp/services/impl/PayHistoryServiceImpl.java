package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.PayHistoryRepo;
import kg.megacom.HouseFlatApp.mappers.PayHistoryMapper;
import kg.megacom.HouseFlatApp.models.dto.PayHistoryDto;
import kg.megacom.HouseFlatApp.models.entities.PayHistory;
import kg.megacom.HouseFlatApp.services.PayHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayHistoryServiceImpl implements PayHistoryService {
    @Autowired
    private PayHistoryRepo payHistoryRepo;

    PayHistoryMapper payHistoryMapper = PayHistoryMapper.PAY_HISTORY_MAPPER;

    @Override
    public PayHistoryDto savePay(PayHistoryDto payHistoryDto) {
        return payHistoryMapper.toDto(payHistoryRepo.save(payHistoryMapper.toEntity(payHistoryDto)));
    }

    @Override
    public PayHistoryDto findPayHistoryById(Long id) {
        PayHistory payHistory = payHistoryRepo.findById(id).orElseThrow(()-> new RuntimeException("Не найден!"));
        return payHistoryMapper.toDto(payHistory);
    }
}
