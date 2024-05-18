package com.api.festivos.festivos.core.interfaces.repocitorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.festivos.festivos.core.dominio.Festivo;

@Repository
public interface IFestivosRepositorio extends JpaRepository<Festivo, Long>{
    
}
