package com.photoapp.modules.photo;

public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public int save(PhotoDAO data) {
        return photoRepository.save(data);
    }

    @Override
    public PhotoDAO findByName(String name) {
        return photoRepository.findByName(name);
    }
}
