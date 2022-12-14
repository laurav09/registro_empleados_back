package com.app.registro_empleados_back.controller;

import com.app.registro_empleados_back.dominio.Pais;
import com.app.registro_empleados_back.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaisController {
    @Autowired
    private IPaisService service;

    @RequestMapping(value = "/pais", produces = {"application/json"}, method = RequestMethod.
            GET)
    public ResponseEntity<List<Pais>> getPaises(){
        List<Pais> paises = service.obtenerPaises();;
        return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
    }
}
