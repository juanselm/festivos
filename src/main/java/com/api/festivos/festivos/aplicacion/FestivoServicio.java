package com.api.festivos.festivos.aplicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.festivos.festivos.core.dominio.Festivo;
import com.api.festivos.festivos.core.interfaces.repocitorios.IFestivosRepositorio;
import com.api.festivos.festivos.core.interfaces.servicios.IFestivosServicio;

@Service
public class FestivoServicio implements IFestivosServicio {

    @Autowired
    private IFestivosRepositorio repositorioFestivos;

    @Override
    public List<Festivo> listar(Date fecha) {
        List<Festivo> festivos = repositorioFestivos.findAll();
        try{
            for (Festivo festivo : festivos) {
                if(festivo.getTipo().getId() == 2){
                    Date nextMonday = getNextMonday(new Date(fecha.getYear(), festivo.getMes() - 1 , festivo.getDia() ));
                    System.out.println(nextMonday);
                }else if(festivo.getTipo().getId() == 3){
                    System.out.println("por pascua");
                }else if(festivo.getTipo().getId() == 4){
                    System.out.println("por pascua + sig lunes");
                }
            }
            System.out.println(fecha.getMonth());
        }catch(Exception e){
            e.toString();
        }
        return festivos;
    }

    @Override
    public Date getDomingoRamos(Date fecha) {
        int year = fecha.getYear() + 1900;
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int days = d + (2 * b + 4 * c + 6 * d + 5) % 7;
        int day = 15 + days;
        int mes = 3;

        if(day > 31){
            day = day - 31;
            mes = 4;
        }
        Date domingoRamos = new Date(year - 1900, mes - 1, day);        
        return domingoRamos;
    }

    @Override
    public Date addDays(Date fecha, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    @Override
    public Boolean check(Date fecha) {
        List<Festivo> festivos = listar(fecha);
        Boolean ckeck = false;
        
        for (Festivo festivo : festivos) {
            if ((festivo.getDia() == fecha.getDay()) && (festivo.getMes() == (fecha.getMonth() - 1))) {
                ckeck = true;
                break;
            }
        }

        return ckeck;
    }

    @Override
    public Date getNextMonday(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        if(calendar.get(Calendar.DAY_OF_WEEK) > calendar.MONDAY){
            fecha = addDays(fecha, 9 - calendar.get(Calendar.DAY_OF_WEEK));
        }else{
            fecha = addDays(fecha, 0);
        }
        return fecha;
    }
    
}
