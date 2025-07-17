package com.photoapp.modules.photo;

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

    public int save(PhotoDAO file) {        
        int result = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PHOTO WHERE NAME = ?", Integer.class, file.name());

        if (result > 0) {
            String update = "UPDATE photo SET payload = ? WHERE name = ?";
            return this.jdbcTemplate.update(update, file.payload(), file.name());
        } else { 
            String insert = "INSERT INTO photo (name, payload) VALUES (?, ?)";
            return this.jdbcTemplate.update(insert, file.name(), file.payload());
        } 

    }

    public PhotoDAO findByName(String name) {
        String sql = "SELECT name, payload FROM photo WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new PhotoDAORowMapper(), name);
    }

}