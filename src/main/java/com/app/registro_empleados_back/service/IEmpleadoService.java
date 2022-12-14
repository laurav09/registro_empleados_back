package com.app.registro_empleados_back.service;
import com.app.registro_empleados_back.dominio.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IEmpleadoService {
    Page<Empleado> obtenerEmpleados(int pageNo, int pageSize);
    Empleado guardarEmpleado(Empleado empleado);
    void eliminarEmpleado(Empleado empleado);
}
