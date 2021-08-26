package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.TypeRepo;
import kg.megacom.HouseFlatApp.exceptions.TypeNotFound;
import kg.megacom.HouseFlatApp.mappers.TypeMapper;
import kg.megacom.HouseFlatApp.models.dto.TypeDto;
import kg.megacom.HouseFlatApp.models.entities.Type;
import kg.megacom.HouseFlatApp.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepo typeRepo;

    TypeMapper typeMapper = TypeMapper.TYPE_MAPPER;

    @Override
    public TypeDto saveType(TypeDto typeDto) {
        typeDto.setActive(true);
        return typeMapper.toDto(typeRepo.save(typeMapper.toEntity(typeDto)));

    }

    @Override
    public TypeDto findTypeById(Long id) {
        Type type = typeRepo.findById(id).orElseThrow(()->new TypeNotFound("Тип по айди не найден!"));
        return typeMapper.toDto(type);
    }
}
