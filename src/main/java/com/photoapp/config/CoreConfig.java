package com.photoapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.photoapp.modules.files.PhotoRepositoryImpl;
import com.photoapp.modules.files.PhotoService;
import com.photoapp.modules.files.PhotoServiceImpl;

@Configuration
public class CoreConfig {
    @Autowired PhotoRepositoryImpl photoRepository;
 
    @Bean public PhotoService createPhotoService() { return new PhotoServiceImpl(photoRepository); };
}