package com.api.festivos.festivos.core.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Festivo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = true)
    private String nombre;

    @Column(name = "dia", nullable = true)
    private int dia;

    @Column(name = "mes", nullable = true)
    private int mes;

    @Column(name = "diaspascua", nullable = true)
    private int diasPascua;

    @ManyToOne
    @JoinColumn(name = "idtipo", insertable = false, updatable = false)
    private Tipo tipo;

}
