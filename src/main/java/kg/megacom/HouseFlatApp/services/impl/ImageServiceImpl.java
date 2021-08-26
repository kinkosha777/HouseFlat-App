package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.ImageRepo;
import kg.megacom.HouseFlatApp.mappers.HouseMapper;
import kg.megacom.HouseFlatApp.mappers.ImageMapper;
import kg.megacom.HouseFlatApp.models.dto.HouseDto;
import kg.megacom.HouseFlatApp.models.dto.ImageDto;
import kg.megacom.HouseFlatApp.models.entities.Image;
import kg.megacom.HouseFlatApp.models.inputs.InputImageData;
import kg.megacom.HouseFlatApp.services.HouseService;
import kg.megacom.HouseFlatApp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepo imageRepo;
    HouseMapper houseMapper = HouseMapper.HOUSE_MAPPER;
    @Autowired
    private HouseService houseService;
    ImageMapper imageMapper = ImageMapper.IMAGE_MAPPER;
    @Override
    public List<InputImageData> saveImage(List<InputImageData> inputImageDataList) {
       inputImageDataList.stream().map(x-> {
           Image image = new Image();
           image.setHouse(houseMapper.toEntity(houseService.findHouseById(x.getHouseId())));
           image.setOrderNum(x.getOrderNum());
           image.setUrl(x.getUrl());
           image = imageRepo.save(image);
           return imageMapper.toDto(image);
       }).collect(Collectors.toList());
       return inputImageDataList;
    }

    @Override
    public void save(String url, HouseDto houseDto) {
        ImageDto imageDto = new ImageDto();
        imageDto.setHouse(houseDto);
        imageDto.setUrl(url);
    }


}
