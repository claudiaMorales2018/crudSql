package com.example.mycrudapp.complementos;

public class MascotasVO {


private int id;
private String nombre;
private String raza;
private String color;
private int edad;


    public MascotasVO() {
    }

    public MascotasVO(int id, String nombre, String raza, String color, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
