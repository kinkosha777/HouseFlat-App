package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends JpaRepository<District,Long> {
}
