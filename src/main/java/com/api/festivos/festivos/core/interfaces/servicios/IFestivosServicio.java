package com.api.festivos.festivos.core.interfaces.servicios;

import java.util.Date;
import java.util.List;

import com.api.festivos.festivos.core.dominio.Festivo;

public interface IFestivosServicio {
    
    public List<Festivo> listar(Date date);

    public Date getDomingoRamos(Date date);
    
    public Date addDays(Date date, int days);
    
    public Boolean check(Date date);

    public Date getNextMonday(Date date);
}
