package com.photoapp.modules.photo;

import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;


public class PhotoRepositoryTest {
    @Test
    public void testRowMapping() throws SQLException {
        PhotoDAO photo = new PhotoDAO("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc", "ABCDEF");

        PhotoRepository photoRepository = Mockito.mock(PhotoRepository.class);
        when(photoRepository.save(photo)).thenReturn(1);

        int result = photoRepository.save(photo);
        assertEquals(1, result);
    }  

 
    @Test
    public void testFindPhoto() {
        PhotoDAO photo = new PhotoDAO("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc", "ABCDEF");

        PhotoRepository photoRepository = Mockito.mock(PhotoRepository.class);
        when(photoRepository.findByName("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc")).thenReturn(photo);

        PhotoDAO foundPhoto = photoRepository.findByName("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc");
        assertEquals(photo.name(), foundPhoto.name());
        assertEquals(photo.payload(), foundPhoto.payload());
    }   
  
}
