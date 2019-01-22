package com.jolsensei.quizparty.Entidades;

public class tarjetaMenu {

    private String nombreOpcion;
    private int iconoOpcion;
    private String descripcionOpcion;

    public tarjetaMenu(String nombre, int icono, String desccripcion){

        nombreOpcion = nombre;
        iconoOpcion = icono;
        descripcionOpcion = desccripcion;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }

    public int getIconoOpcion() {
        return iconoOpcion;
    }

    public void setIconoOpcion(int iconoOpcion) {
        this.iconoOpcion = iconoOpcion;
    }

    public String getDescripcionOpcion() {
        return descripcionOpcion;
    }

    public void setDescripcionOpcion(String descripcionOpcion) {
        this.descripcionOpcion = descripcionOpcion;
    }
}
