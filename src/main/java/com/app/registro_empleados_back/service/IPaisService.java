package com.app.registro_empleados_back.service;

import com.app.registro_empleados_back.dominio.Pais;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPaisService {
    List<Pais> obtenerPaises();
}
