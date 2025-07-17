package com.photoapp.modules.photo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class PhotoDAORowMapperTest {
    @Test
    public void testRowMapping() throws SQLException {
        ResultSet mockResultSet = mock(ResultSet.class);

        when(mockResultSet.getString("name")).thenReturn("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc");
        when(mockResultSet.getString("payload")).thenReturn("ABCDED");

        PhotoDAORowMapper rowMapper = new PhotoDAORowMapper();
        PhotoDAO photoDAO = rowMapper.mapRow(mockResultSet, 1);

        assertEquals("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc", photoDAO.name());
        assertEquals("ABCDED", photoDAO.payload() );
    }  
}
