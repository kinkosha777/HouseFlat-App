package kg.megacom.HouseFlatApp.dao;

import kg.megacom.HouseFlatApp.enums.CodeStatus;
import kg.megacom.HouseFlatApp.models.entities.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepo extends JpaRepository<Code,Long> {
//    Code findByUserId(Long id);

    Code findByUserIdAndCodeStatusNot(Long id, CodeStatus codeStatus);
}
