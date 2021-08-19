package kg.megacom.HouseFlatApp.services;

import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.dto.ImageDto;
import kg.megacom.HouseFlatApp.models.inputs.InputImageData;

import java.util.List;

public interface ImageService {
   List<InputImageData>  saveImage(List<InputImageData> inputImageDataList);
    void save(String url, HouseDto houseDto);
}
