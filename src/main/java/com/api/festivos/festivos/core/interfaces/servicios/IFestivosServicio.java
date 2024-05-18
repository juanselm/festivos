package com.api.festivos.festivos.core.interfaces.servicios;

import java.util.Date;
import java.util.List;

import com.api.festivos.festivos.core.dominio.Festivo;

public interface IFestivosServicio {
    
    public List<Festivo> listar(Date fecha);

    public Date getDomingoRamos(Date fecha);
    
    public Date getDomingonPascua(Date fecha);
    
    public List<Festivo> getFijos(Date fecha);

    public List<Festivo> getLeyPFestivos(Date fecha);

    public List<Festivo> getBasadosPascua(Date fecha);

    public List<Festivo> getBasadosPascuaLeyP(Date fecha);


}
