package com.photoapp.modules.photo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
 
@SpringBootTest
@AutoConfigureMockMvc
public class PhotoDAOTest {
    @Test
	public void testPhoto() {
		PhotoDAO photo = new PhotoDAO("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc", "ABCDCDE");

		assertEquals("82e8dcd4-29e3-49db-89a4-ca5e24dce3bc", photo.name() );
		assertEquals("ABCDCDE", photo.payload() );
	}
}
