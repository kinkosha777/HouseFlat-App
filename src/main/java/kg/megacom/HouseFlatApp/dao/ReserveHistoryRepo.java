package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.ReserveHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveHistoryRepo extends JpaRepository<ReserveHistory,Long> {
    List<ReserveHistory> findByHouseId(Long id);
}
