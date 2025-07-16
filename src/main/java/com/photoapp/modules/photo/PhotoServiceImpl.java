package com.photoapp.modules.photo;

public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public void addPhotoFile(PhotoDAO data) {
        photoRepository.addPhotoFile(data);
    }

    @Override
    public PhotoDAO getPhotoFile(String name) {
        return photoRepository.getPhotoFile(name);
    }
}
