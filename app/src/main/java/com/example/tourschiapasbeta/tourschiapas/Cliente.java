package com.example.tourschiapasbeta.tourschiapas;

import java.io.Serializable;

public class Cliente implements Serializable {
    String nombre, apellidos, hotel, correo;
    int asiento;

    public Cliente() {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.hotel = hotel;
        this.correo = correo;
        this.asiento = asiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getAsiento(){ return asiento; }

    public void setAsiento(int asiento) { this.asiento = asiento; }

    @Override
    public String toString(){
        return "Nombre: "+getNombre()+"\n"+"Apellidos: "+getApellidos()+"\n"+"Hotel: "+getHotel()+"\n"+"Asiento: "+getAsiento();
    }
}
