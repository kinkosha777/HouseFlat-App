package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region,Long> {
}
