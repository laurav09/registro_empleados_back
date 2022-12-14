package com.app.registro_empleados_back.jpa;

import com.app.registro_empleados_back.dominio.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository  extends JpaRepository<Pais, Long> {

}
