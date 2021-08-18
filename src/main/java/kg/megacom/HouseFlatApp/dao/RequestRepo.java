package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RequestRepo extends JpaRepository<Request,Long> {
//    long countAllByCodeAndStartDateAfter(Long user_id, Date date);
}
