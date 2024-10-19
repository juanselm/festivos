package com.api.festivos.festivos;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.api.festivos.festivos.core.dominio.Festivo;
import com.api.festivos.festivos.core.interfaces.servicios.IFestivosServicio;
import com.api.festivos.festivos.presentacion.FestivoController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FestivoController.class)
class FestivoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IFestivosServicio servicioFestivos;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configurar el comportamiento del servicio mock
        Festivo festivo1 = new Festivo();
        festivo1.setNombre("Festivo 1");
        festivo1.setDia(1);
        festivo1.setMes(1);
        festivo1.setDiasPascua(0);

        Festivo festivo2 = new Festivo();
        festivo2.setNombre("Festivo 2");
        festivo2.setDia(2);
        festivo2.setMes(1);
        festivo2.setDiasPascua(1);

        List<Festivo> festivos = Arrays.asList(festivo1, festivo2);
        when(servicioFestivos.listar(any(Date.class))).thenReturn(festivos);

        when(servicioFestivos.check(any(Date.class))).thenReturn(true);
    }

    @Test
    void testListarFestivos() throws Exception {
        mockMvc.perform(get("/api/festivos/listar")
                .param("fecha", dateFormat.format(new Date())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].nombre", is("Festivo 1")))
                .andExpect(jsonPath("$[1].nombre", is("Festivo 2")));
    }

    @Test
    void testCheckHolidays() throws Exception {
        mockMvc.perform(get("/api/festivos/check")
                .param("fecha", dateFormat.format(new Date())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

    // Agrega más pruebas para otros endpoints según sea necesario
}