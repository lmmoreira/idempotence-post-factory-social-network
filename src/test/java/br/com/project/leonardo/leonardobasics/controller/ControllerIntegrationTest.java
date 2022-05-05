package br.com.project.leonardo.leonardobasics.controller;

import br.com.project.leonardo.leonardobasics.LeonardoBasicsApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class ControllerIntegrationTest extends LeonardoBasicsApplicationTests {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper objectMapper;

}