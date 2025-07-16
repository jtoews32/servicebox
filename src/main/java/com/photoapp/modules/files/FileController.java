package com.photoapp.modules.files;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FileController {
    @Autowired
    PhotoService photoService;

    @PostMapping("/upload")
    @CrossOrigin(origins = "http://localhost:3000") 
    public String upload(@RequestBody Base64PhotoFile data) {
        System.out.println("Received file: " + data.payload());
        String base64Image = data.payload();

        if (base64Image.startsWith("data:image/jpeg;base64,")) {
            String base64Data = base64Image.substring(base64Image.indexOf(",") + 1);
            byte[] decodedBytes = Base64.getDecoder().decode(base64Data);


            String str = new String(decodedBytes, StandardCharsets.UTF_8);
            System.out.println(str);

            System.out.println("Received File Name: " + data.name());


            photoService.addPhotoFile(data);

            return "Image uploaded and processed successfully!";
        } else {

            System.out.println("Received name: " + data.name());
            return "Invalid image format. Expected data:image/jpeg;base64,";
        }
    }


    @PostMapping("/download")
    @CrossOrigin(origins = "http://localhost:3000") 
    public String download(@RequestBody Base64PhotoFile data) {


        
    }
}