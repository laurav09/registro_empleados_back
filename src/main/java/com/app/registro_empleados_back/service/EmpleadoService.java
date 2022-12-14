package com.app.registro_empleados_back.service;
import com.app.registro_empleados_back.dominio.Empleado;
import com.app.registro_empleados_back.jpa.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private EmpleadoRepository repository;

    public Page<Empleado> obtenerEmpleados(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Empleado> listEmpleados = repository.findAll(pageable);
        return listEmpleados;
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        List<Empleado> lista= repository.findAll();
        Empleado newEmpleado=empleado;
        String[] emailsplit=empleado.getEmail().split("@");

        lista.forEach((emp) ->  {
            if(emp.getEmail().equals(newEmpleado.getEmail())) {
                String empEmail=emp.getEmail().split("@")[0];
                String emailIDstr="";
                Integer emailID=1;

                for(int i=0;i<empEmail.length();i++)
                {
                    if(Character.isDigit(empEmail.charAt(i))){
                        emailIDstr+=empEmail.charAt(i);
                    }
                }
                if(!emailIDstr.isEmpty()){
                    System.out.println("EXISTE numero");
                    System.out.println(emailIDstr);
                    emailID+=Integer.parseInt(emailIDstr);
                }
                emailIDstr=emailID.toString();
                newEmpleado.setEmail(emailsplit[0]+emailIDstr+emailsplit[1]);
                return;
            }
        });
        empleado = repository.save(newEmpleado);
        return empleado;
    }

    public void eliminarEmpleado(Empleado empleado) {
        repository.delete(empleado);
    }
}
