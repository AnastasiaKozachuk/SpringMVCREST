package com.test.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * For testing  in 'my.properties' file copy value from 'testFilePath' and paste to 'serverFilePath'
 *
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( {"file:src/main/webapp/WEB-INF/springConfig-servlet.xml"})
@WebAppConfiguration
public class APIControllerTest {


    private MockMvc mockMvc;
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void givenFilterURI1_whenMockMVC_thenVerifyResponse() throws Exception {
        MvcResult mvcResult1 = this.mockMvc.perform(get("/api/db?year=1975&state=current&gender=male"))
                .andExpect(status().isOk()).andReturn();

        MvcResult mvcResult2 = this.mockMvc.perform(get("/api/file?year=1975&state=current&gender=male"))
                .andExpect(status().isOk()).andReturn();

        Assert.assertEquals(mvcResult1.getResponse().getContentAsString(),
                mvcResult2.getResponse().getContentAsString());
    }

    @Test
    public void givenFilterURI2_whenMockMVC_thenVerifyResponse() throws Exception {

       this.mockMvc.perform(get("/api/db?year=1975"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
               .andExpect(jsonPath("$..id").isArray());

    }

    @Test
    public void givenFilterURI3_whenMockMVC_thenVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/api/file?year=1975"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$..id").isArray());
    }

    @Test
    public void givenFilterURI4_whenMockMVC_thenVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/api/file?year=1975&state=current,repaid"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$..id").isArray());
    }

    @Test
    public void givenFilterURI5_whenMockMVC_thenVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/api/db?year=197&state=currentw"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$..id").doesNotExist());
    }

}
