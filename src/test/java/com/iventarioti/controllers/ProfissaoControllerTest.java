package com.iventarioti.controllers;

import com.google.gson.Gson;
import com.iventarioti.dto.ProfissaoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfissaoControllerTest {

    private final String ENDPOINT = "/profissoes";

    @Autowired
    private ProfissaoController profissaoController;

    @Autowired
    private MockMvc mockMvc;

    private ProfissaoDTO getProfissaoDTO() {
        ProfissaoDTO profissaoDTO = new ProfissaoDTO();
        profissaoDTO.setTitulo("Teste Titulo");
        profissaoDTO.setDescricao("Teste Descricao");

        return profissaoDTO;
    }

    private Gson getGson() {
        return new Gson();
    }

    @Test
    public void save() throws Exception{
        this.mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getGson().toJson(getProfissaoDTO())))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        this.mockMvc.perform(get(ENDPOINT +"/4"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void findAll() throws Exception{
        this.mockMvc.perform(get(ENDPOINT +"/find-all"))
                .andDo(print()).andExpect(status().isOk());
    }

}
