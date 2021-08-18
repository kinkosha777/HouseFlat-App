package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.CityVillage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityVillageRepo extends JpaRepository<CityVillage,Long> {
}
