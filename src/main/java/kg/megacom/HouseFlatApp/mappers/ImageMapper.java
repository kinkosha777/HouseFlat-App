package kg.megacom.HouseFlatApp.mappers;

import kg.megacom.HouseFlatApp.models.dto.ImageDto;
import kg.megacom.HouseFlatApp.models.entities.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ImageMapper extends BaseMapper<ImageDto, Image> {
    ImageMapper IMAGE_MAPPER = Mappers.getMapper(ImageMapper.class);
}
