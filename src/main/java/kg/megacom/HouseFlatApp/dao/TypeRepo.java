package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type,Long> {
}
