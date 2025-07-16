package com.photoapp.modules.photo;

public interface PhotoService {
    void addPhotoFile(PhotoDAO file);
    PhotoDAO getPhotoFile(String name);
}
