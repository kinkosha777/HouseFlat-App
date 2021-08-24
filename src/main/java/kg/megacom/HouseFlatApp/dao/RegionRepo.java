package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepo extends JpaRepository<Region,Long> {

    List<Region>  findByName(String name);
}
