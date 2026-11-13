package com.example.sistema.entity; //

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 👇 NUEVO: No puede estar vacío ni ser nulo
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

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Email(message = "El formato del correo no es válido")
    @Column(name = "correo", length = 100, unique = true)
    private String correo;

    @Column(name = "estado_civil", length = 20)
    private String estadoCivil;

    @Column(name = "telefono", length = 50, nullable = false)
    private String telefono;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "ciudad_id", nullable = false)
    private Long ciudadId;

    @Column(name = "nacionalidad_id", nullable = false)
    private Long nacionalidadId;


    @Column(name = "estado_paciente", length = 20, nullable = false)
    private String estadoPaciente = "ACTIVO"; // Valor por defecto

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Long getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(Long nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}



