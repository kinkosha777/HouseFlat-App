package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
//    List<User> findPhoneByUserId(Long id,String phone);
User findByPhone(String phone);
}
