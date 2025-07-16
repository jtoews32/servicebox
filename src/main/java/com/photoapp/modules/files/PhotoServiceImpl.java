package com.photoapp.modules.files;

public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepositoryImpl photoRepository;

    public PhotoServiceImpl(PhotoRepositoryImpl photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public void addPhotoFile(Base64PhotoFile data) {

        photoRepository.addPhotoFile(data);
    }


    @Override
    public String getPhotoFile(String name) {

        return photoRepository.getPhotoFile(name);
    }


    
}
