package com.photoapp.modules.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.photoapp.modules.files.Base64PhotoFile;


@Repository
public class PhotoRepositoryImpl   {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public PhotoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPhotoFile(Base64PhotoFile file) {
        
    
        int result = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PHOTO WHERE NAME = ?", Integer.class, file.name());
 
        System.out.println("Checking if photo with name " + file.name() + " exists. Result: " + result);

        if (result > 0) {
            System.out.println("Photo with name " + file.name() + " already exists.");

            String update = "UPDATE photo SET payload = ? WHERE name = ?";
            this.jdbcTemplate.update(update, file.payload(), file.name());

        } else { 
            String insert = "INSERT INTO photo (name, payload) VALUES (?, ?)";
            this.jdbcTemplate.update(insert, file.name(), file.payload());
        } 
    }


    public String getPhotoFile(String name) {
        System.out.println("Retrieving photo with name: " + name);

        Base64PhotoFile result = jdbcTemplate.queryForObject("SELECT * FROM PHOTO WHERE NAME = ?", Base64PhotoFile.class, name);
        
        if (result != null) {
            System.out.println("Photo found: " + result.name());
            return result.payload();
        } else {
            System.out.println("Photo not found with name: " + name);
            return null;
        }

    }
}