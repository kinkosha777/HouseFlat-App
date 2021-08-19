package kg.megacom.HouseFlatApp.controllers;

import kg.megacom.HouseFlatApp.models.dto.ImageDto;
import kg.megacom.HouseFlatApp.models.inputs.InputImageData;
import kg.megacom.HouseFlatApp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/save-image")
    public ResponseEntity<List<InputImageData>> save(@RequestBody List<InputImageData> inputImageDataList){
        return new ResponseEntity<>(imageService.saveImage(inputImageDataList), HttpStatus.CREATED);
    }

}
