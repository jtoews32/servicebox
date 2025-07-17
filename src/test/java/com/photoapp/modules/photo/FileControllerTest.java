package com.photoapp.modules.photo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FileController.class)
class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhotoService service;

    @Test
    void testUpload() throws Exception {
        this.mockMvc.perform(post("/upload")
            .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
            .content("{\"name\":\"82e8dcd4-29e3-49db-89a4-ca5e24dce3bc\", \"payload\":\"82e8dcd4\"}")
            .accept(org.springframework.http.MediaType.APPLICATION_JSON)) 
            .andExpect(status().isOk()); 
    }

    @Test
    void testDownload() throws Exception {
        this.mockMvc.perform(post("/download")
            .contentType(org.springframework.http.MediaType.APPLICATION_JSON) 
            .content("{\"name\":\"82e8dcd4-29e3-49db-89a4-ca5e24dce3bc\", \"payload\":\"\"}")
            .accept(org.springframework.http.MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()); 
    }  
}
