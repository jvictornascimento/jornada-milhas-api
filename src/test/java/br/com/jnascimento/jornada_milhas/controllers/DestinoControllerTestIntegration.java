package br.com.jnascimento.jornada_milhas.controllers;

import br.com.jnascimento.jornada_milhas.services.DepoimentoService;
import br.com.jnascimento.jornada_milhas.services.DestinoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class DestinoControllerTestIntegration {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private DestinoService service;

    @Test
    void deveriaRetornarUm200ParaSolicitacoesGetSemParamento() throws Exception {
        var response =  mvc.perform(
                get("/destinos")
        ).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }
    @Test
    void deveriaRetornarUm200ParaSolicitacoesGetBuscarComParamento() throws Exception {
        var response =  mvc.perform(
                get("/destinos/buscar?nome=pariz")
        ).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    void deveriaRetornarUm200ParaSolicitacoesGetComParamento() throws Exception {
        var response =  mvc.perform(
                get("/destinos/1")
        ).andReturn().getResponse();

        assertEquals(200,response.getStatus());
    }

    @Test
    void deveriaRetornarUm201ParaSolicitacoesPost()throws Exception {
        String json = """
                {
                    	"nome":"China",
                     	"foto1":"caminho-url-para-foto1",
                     	"foto2":"caminho-url-para-foto2",
                     	"meta":"alguma meta",
                     	"textoDescritivo":"texto"
                }""";

        var response = mvc.perform(
                post("/destinos")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(201, response.getStatus());
    }

    @Test
    void deveriaRetornarUm200ParaSolicitacoesPut()throws Exception {
        String json = """
                {
                  "foto":"url_de_alguma_foto"
                }""";

        var response = mvc.perform(
                put("/destinos/1")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
    }

    @Test
    void deveriaRetornarUm204ParaSolicitacoesDelete()throws Exception {
        var response = mvc.perform(
                delete("/destinos/1")
        ).andReturn().getResponse();

        assertEquals(204, response.getStatus());
    }
}