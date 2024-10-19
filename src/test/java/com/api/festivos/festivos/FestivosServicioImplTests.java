package com.api.festivos.festivos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.festivos.festivos.core.dominio.Festivo;
import com.api.festivos.festivos.core.interfaces.servicios.IFestivosServicio;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FestivosServicioImplTests {

    @Autowired
    private IFestivosServicio festivosServicio;

    @Test
    void testListar() {
        Date date = new Date();
        List<Festivo> festivos = festivosServicio.listar(date);
        assertNotNull(festivos);
        // Agrega más aserciones según sea necesario
    }

    @Test
    void testGetDomingoRamos() {
        Date date = new Date();
        Date domingoRamos = festivosServicio.getDomingoRamos(date);
        assertNotNull(domingoRamos);
        // Agrega más aserciones según sea necesario
    }

    @Test
    void testAddDays() {
        Date date = new Date();
        Date newDate = festivosServicio.addDays(date, 5);
        assertNotNull(newDate);
        // Agrega más aserciones según sea necesario
    }

    @Test
    void testCheck() {
        Date date = new Date();
        Boolean result = festivosServicio.check(date);
        assertNotNull(result);
        // Agrega más aserciones según sea necesario
    }

    @Test
    void testGetNextMonday() {
        Date date = new Date();
        Date nextMonday = festivosServicio.getNextMonday(date);
        assertNotNull(nextMonday);
        // Agrega más aserciones según sea necesario
    }
}