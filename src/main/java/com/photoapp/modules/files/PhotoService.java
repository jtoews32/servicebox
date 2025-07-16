package com.photoapp.modules.files;

public interface PhotoService {
    void addPhotoFile(Base64PhotoFile file);
    String getPhotoFile(String name);
 
}
