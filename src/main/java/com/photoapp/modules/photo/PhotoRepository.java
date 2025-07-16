package com.photoapp.modules.photo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class PhotoRepository   {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public PhotoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPhotoFile(PhotoDAO file) {
        
     
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

    // findUserById
    public PhotoDAO  getPhotoFile(String name) {
        String sql = "SELECT name, payload FROM photo WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new PhotoDAORowMapper(), name);
    }

}