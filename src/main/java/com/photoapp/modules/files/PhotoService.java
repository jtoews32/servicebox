package com.photoapp.modules.files;

public interface PhotoService {
    void addPhotoFile(Base64PhotoFile file);
    Base64PhotoFile getPhotoFile(String name);
}
