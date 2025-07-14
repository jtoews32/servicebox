package com.photoapp.servicebox.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;   
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingTests {

	@Test
	public void testGreeting() {
		Greeting greet = new Greeting(1, "Hello");

		assertEquals(1, greet.id());
		assertEquals("Hello", greet.content());
	}

    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGreetingEndpoint() throws Exception {
         mockMvc.perform(get("/greeting").param("name", "Test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Test!"));
    } 
}
