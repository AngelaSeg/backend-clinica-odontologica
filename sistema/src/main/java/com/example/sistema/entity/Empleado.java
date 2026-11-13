package com.example.sistema.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El tipo de identificación es obligatorio")
    @Column(name = "tipo_identificacion", length = 20, nullable = false)
    private String tipoIdentificacion;

    @NotBlank(message = "El número de identificación es obligatorio")
    @Column(name = "nro_identificacion", length = 20, nullable = false, unique = true)
    private String nroIdentificacion;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "sexo", length = 10)
    private String sexo;

    @NotNull(message = "El rol es obligatorio")
    @Column(name = "rol_id", nullable = false)
    private Long rolId;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Email(message = "El formato del correo no es válido")
    @Column(name = "correo", length = 100, unique = true)
    private String correo;

    @Column(name = "telefono", length = 50, nullable = false)
    private String telefono;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "estado_empleado", length = 20, nullable = false)
    private String estadoEmpleado = "ACTIVO";

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoIdentificacion() { return tipoIdentificacion; }
    public void setTipoIdentificacion(String tipoIdentificacion) { this.tipoIdentificacion = tipoIdentificacion; }

    public String getNroIdentificacion() { return nroIdentificacion; }
    public void setNroIdentificacion(String nroIdentificacion) { this.nroIdentificacion = nroIdentificacion; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEstadoEmpleado() { return estadoEmpleado; }
    public void setEstadoEmpleado(String estadoEmpleado) { this.estadoEmpleado = estadoEmpleado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
}