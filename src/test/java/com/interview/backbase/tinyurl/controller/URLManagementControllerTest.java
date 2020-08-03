package com.interview.backbase.tinyurl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class URLManagementControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order(1)
	public void testTinyURLCreationFromOriginalURL() throws Exception {
		MvcResult tinyURLResult= mockMvc.perform(post("/short").param("url","https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38"))
                .andExpect(status().isCreated()).andReturn();
        assertEquals(tinyURLResult.getResponse().getContentAsString(),"bM");
	}
	
@Test
@Order(2)
public void testTinyURLToOriginalURLConversion() throws Exception {
	MvcResult conversionResult = mockMvc.perform(get("/long").param("tiny","bM")).andExpect(status().isOk()).andReturn();
	assertEquals(conversionResult.getResponse().getContentAsString(), "https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json");
}
@Test
@Order(3)
public void NoURLFoundForIncorrectTinyURL() throws Exception {
	MvcResult conversionResult = mockMvc.perform(get("/long").param("tiny","gtrc")).andExpect(status().isNotFound()).andReturn();
	String result =conversionResult.getResponse().getContentAsString();
	System.out.println(result);
	assertEquals(conversionResult.getResponse().getContentAsString(), "Mapping for tinyURL to original not found");
	
}

}
