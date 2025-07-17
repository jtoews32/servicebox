package com.photoapp.modules.photo;

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
    public int upload(@RequestBody PhotoDAO data) {
        return photoService.save(data);
    }

    @PostMapping("/download")
    @CrossOrigin(origins = "http://localhost:3000") 
    public PhotoDAO download(@RequestBody PhotoDAO data) {
        return photoService.findByName(data.name());
    }
}