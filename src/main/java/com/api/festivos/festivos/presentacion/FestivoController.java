package com.api.festivos.festivos.presentacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.festivos.festivos.core.dominio.Festivo;
import com.api.festivos.festivos.core.interfaces.servicios.IFestivosServicio;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

    @Autowired
    private IFestivosServicio servicioFestivos;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    @GetMapping("listar")
    public ResponseEntity<List<Festivo>> listarFestivos(@RequestParam("fecha") Date fecha) {
        return ResponseEntity.ok(servicioFestivos.listar(fecha));
        
    }
    
    @GetMapping("check")
    public boolean checkHolidays(@RequestParam("fecha") Date fecha) {
        return servicioFestivos.check(fecha);
        
    }
    
}
