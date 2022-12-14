package com.app.registro_empleados_back.controller;

import com.app.registro_empleados_back.dominio.Empleado;
import com.app.registro_empleados_back.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService service;

    @RequestMapping (value = "/empleado", produces = {"application/json"}, method = RequestMethod.
            GET)
    public ResponseEntity<Page<Empleado>>getEmpleados(@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
                                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Empleado> listaEmpleados = service.obtenerEmpleados(pageNo,pageSize);;
        return new ResponseEntity<Page<Empleado>>(listaEmpleados, HttpStatus.OK);
    }

    @RequestMapping (value = "/empleado", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Empleado> saveEmpleado (@RequestBody Empleado empleado) {

        Empleado empleado1 = service.guardarEmpleado(empleado);
            return new ResponseEntity<Empleado>(empleado1, HttpStatus.OK);
    }

    @RequestMapping (value = "/empleado", produces = {"application/json"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteEmpleado(@RequestBody Empleado empleado){
        try {
            service.eliminarEmpleado(empleado);
            return new ResponseEntity(service.obtenerEmpleados(0,10), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
