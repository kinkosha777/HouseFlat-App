package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.PayHistoryDto;
import kg.megacom.HouseFlatApp.models.entities.PayHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PayHistoryMapper  extends BaseMapper<PayHistoryDto, PayHistory>{
    PayHistoryMapper PAY_HISTORY_MAPPER = Mappers.getMapper(PayHistoryMapper.class);
}
