package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.TypeDto;

public interface TypeService {
    TypeDto saveType(TypeDto typeDto);
    TypeDto findTypeById(Long id);
}
