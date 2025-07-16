package com.photoapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.photoapp.modules.photo.PhotoRepository;
import com.photoapp.modules.photo.PhotoService;
import com.photoapp.modules.photo.PhotoServiceImpl;

@Configuration
public class CoreConfig {
    @Autowired PhotoRepository photoRepository;
 
    @Bean public PhotoService createPhotoService() { return new PhotoServiceImpl(photoRepository); };
}