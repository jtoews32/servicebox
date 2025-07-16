package com.photoapp.modules.photo;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoDAORowMapper implements RowMapper<PhotoDAO> {
    public PhotoDAO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PhotoDAO(rs.getString("name"), rs.getString("payload"));
    }
}
