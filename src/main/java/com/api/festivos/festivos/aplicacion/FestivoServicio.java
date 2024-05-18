package com.api.festivos.festivos.aplicacion;

import java.util.ArrayList;
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
        }catch(Exception e){
            e.toString();
        }
        return festivos;
    }

    @Override
    public List<Festivo> getDomingoRamos(Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDomingoRamos'");
    }

    @Override
    public List<Festivo> getDomingonPascua(Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDomingonPascua'");
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
