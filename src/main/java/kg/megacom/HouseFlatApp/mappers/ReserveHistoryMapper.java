package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.ReserveHistoryDto;
import kg.megacom.HouseFlatApp.models.entities.ReserveHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ReserveHistoryMapper extends BaseMapper<ReserveHistoryDto, ReserveHistory> {
    ReserveHistoryMapper RESERVE_HISTORY_MAPPER = Mappers.getMapper(ReserveHistoryMapper.class);
}
