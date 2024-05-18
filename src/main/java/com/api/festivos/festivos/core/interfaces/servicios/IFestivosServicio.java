package com.api.festivos.festivos.core.interfaces.servicios;

import java.util.Date;
import java.util.List;

import com.api.festivos.festivos.core.dominio.Festivo;

public interface IFestivosServicio {
    
    public List<Festivo> listar(Date year);

    public Date getDomingoRamos(Date fecha);
    
    public Date addDays(Date fecha, int days);
    
    public Boolean check(Date fecha);

    public Date getNextMonday(Date fecha);
}
