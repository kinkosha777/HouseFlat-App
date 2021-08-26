package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.PayHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayHistoryRepo extends JpaRepository <PayHistory,Long> {
    List<PayHistory> findByReserveHistoryId(Long reserve_id);
}
