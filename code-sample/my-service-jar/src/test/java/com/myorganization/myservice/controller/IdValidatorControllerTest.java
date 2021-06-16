package com.myorganization.myservice.controller;


import com.myorganization.myservice.Application;
import com.myorganization.myservice.model.response.ValidatorResponse;
import com.myorganization.myservice.stub.RequestStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, 
                classes = {Application.class})
@TestPropertySource( locations = "classpath:test.properties")
public class IdValidatorControllerTest {
      
	@Autowired
    private WebApplicationContext wac;
    	
	private MockMvc mockMvc;
	
    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();        
    }
    
    @Test   
    public void idValidatorOK() throws Exception {    
    	    	   	    	
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/idvalidator")      
        	.contentType("application/json")
        	.content(RequestStub.insertRequestIdValidatorStub("ID","A00000000","724")))
            .andExpect(status().isOk())
            .andReturn();

        String strResponse = result.getResponse().getContentAsString();
        ValidatorResponse ValidatorResponse = objectMapper.readValue(strResponse, ValidatorResponse.class);
        assertNull(ValidatorResponse.getErrors());
        assertEquals("CIF", ValidatorResponse.getIdDocumentType());
    
    }
    
    @Test   
    public void idValidatorKO() throws Exception {    
    	    	   	    	
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/idvalidator")      
        	.contentType("application/json")
        	.content(RequestStub.insertRequestIdValidatorStub("ID","A1234567","724")))
            .andExpect(status().isOk())
            .andReturn();

        String strResponse = result.getResponse().getContentAsString();
        ValidatorResponse ValidatorResponse = objectMapper.readValue(strResponse, ValidatorResponse.class);
        assertNull(ValidatorResponse.getIdDocumentType());
        assertEquals("ICESD004", ValidatorResponse.getErrors().get(0).getCode());
        assertEquals("Invalid id", ValidatorResponse.getErrors().get(0).getMessage());

    }

    @Test
    public void idValidatorOKIdTypeNullIdCountryNull() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/idvalidator")
                .contentType("application/json")
                .content(RequestStub.insertRequestIdValidatorStub("1R")))
                .andExpect(status().isOk())
                .andReturn();

        String strResponse = result.getResponse().getContentAsString();
        ValidatorResponse ValidatorResponse = objectMapper.readValue(strResponse, ValidatorResponse.class);
        assertNull(ValidatorResponse.getErrors());
        assertEquals("DNI", ValidatorResponse.getIdDocumentType());

    }
   
    
}
