package com.app.registro_empleados_back.jpa;

import com.app.registro_empleados_back.dominio.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}

