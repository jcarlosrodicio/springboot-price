package com.springboot.app.price.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PriceControllerTest.class);

	@Autowired
    private MockMvc mockMvc;
 
    @Autowired
    ObjectMapper objectmapper;
    
    @Test
    void canRetrieveTest1() throws Exception {
    	String response = mockMvc.perform(get("http://localhost:8080/price/2020-06-14 10:00:00/product/35455/brand/1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price").value("35.5"))
                .andReturn().getResponse().getContentAsString();
    	
    	logger.info("response: " + response);
    }
    
    @Test
    void canRetrieveTest2() throws Exception {
    	String response = mockMvc.perform(get("http://localhost:8080/price/2020-06-14 16:00:00/product/35455/brand/1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price").value("25.45"))
                .andReturn().getResponse().getContentAsString();
    	logger.info("response: " + response);
    }
    
    @Test
    void canRetrieveTest3() throws Exception {
    	String response = mockMvc.perform(get("http://localhost:8080/price/2020-06-14 21:00:00/product/35455/brand/1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price").value("35.5"))
                .andReturn().getResponse().getContentAsString();
    	logger.info("response: " + response);
    }
    
    @Test
    void canRetrieveTest4() throws Exception {
    	String response = mockMvc.perform(get("http://localhost:8080/price/2020-06-15 10:00:00/product/35455/brand/1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price").value("30.5"))
                .andReturn().getResponse().getContentAsString();
    	logger.info("response: " + response);
    }
    
    @Test
    void canRetrieveTest5() throws Exception {
    	String response = mockMvc.perform(get("http://localhost:8080/price/2020-06-16 21:00:00/product/35455/brand/1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.price").value("38.95"))
                .andReturn().getResponse().getContentAsString();
    	logger.info("response: " + response);
    }
    
    @Test
    void canRetrieveTestNoContent() throws Exception {
    	String response = mockMvc.perform(get("http://localhost:8080/price/2021-06-16 21:00:00/product/35455/brand/1"))
                .andExpect(status().is(HttpStatus.NO_CONTENT.value()))
                .andReturn().getResponse().getContentAsString();
    	logger.info("response: " + response);
    }
}
