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
        List<Festivo> festivos = new ArrayList<>();
        try{
            festivos = repositorioFestivos.findAll();
            getDomingonPascua(fecha);
        }catch(Exception e){
            e.toString();
        }
        return festivos;
    }

    @Override
    public Date getDomingoRamos(Date fecha) {
        int anho = fecha.getYear() + 1900;
        int a = anho % 19;
        int b = anho % 4;
        int c = anho % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;
        int dia = 15 + dias;
        int mes = 3;

        if(dia>31){
            dia = dia - 31;
            mes = 4;
        }
        Date domingoRamos = new Date(anho - 1900, mes - 1, dia);        
        return domingoRamos;
    }

    @Override
    public Date getDomingonPascua(Date fecha) {
        Calendar domingoPascua = Calendar.getInstance();
        domingoPascua.setTime(getDomingoRamos(fecha));
        domingoPascua.add(Calendar.DATE, 7);
        System.out.println(domingoPascua.getTime());
        return domingoPascua.getTime();
    }

    @Override
    public List<Festivo> getFijos(Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFijos'");
    }

    @Override
    public List<Festivo> getLeyPFestivos(Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLeyPFestivos'");
    }

    @Override
    public List<Festivo> getBasadosPascua(Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBasadosPascua'");
    }

    @Override
    public List<Festivo> getBasadosPascuaLeyP(Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBasadosPascuaLeyP'");
    }
    
}
