package com.example.tourschiapasbeta.tourschiapas;

public class Socios {
    private String idSocio, nombre, apellido, correo;
    private int idEmpresa;

    public Socios(String nombre, String apellido, String correo, int idEmpresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
