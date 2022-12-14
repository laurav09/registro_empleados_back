package com.app.registro_empleados_back.service;

import com.app.registro_empleados_back.dominio.Pais;
import com.app.registro_empleados_back.jpa.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService implements IPaisService{
    @Autowired
    private PaisRepository repository;

    public List<Pais> obtenerPaises() {
        List<Pais> paises = repository.findAll();
        return paises;
    }
}
