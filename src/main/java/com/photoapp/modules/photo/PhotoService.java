package com.photoapp.modules.photo;

public interface PhotoService {
    int save(PhotoDAO file);
    PhotoDAO findByName(String name);
}
