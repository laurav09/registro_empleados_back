package com.app.registro_empleados_back.dominio;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @NotNull()
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "primer_nombre",nullable = false, length = 20)
    private String primerNombre;
    @Column(name = "segundo_nombre", length = 50)
    private String segundoNombre;
    @Column(name = "primer_apellido",nullable = false, length = 20)
    private String primerApellido;
    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;
    @Column(nullable = false, length = 300)
    private String email;
}
