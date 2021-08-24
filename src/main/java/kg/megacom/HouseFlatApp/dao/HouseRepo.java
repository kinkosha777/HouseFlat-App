package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.District;
import kg.megacom.HouseFlatApp.models.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House,Long> {
    List<House> findHouseByDistrictId(Long id);
    List<House> findHouseByCityVillageId(Long id);
    List<House> findHouseByTypeId(Long id);
    List<House> findHouseByRooms(int room);
    List<House> findHouseByFloor(int floor);
    List<House> findHouseByInternet(boolean internet);
    List<House> findHouseByFurniture(boolean furniture);
}
