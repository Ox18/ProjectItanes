package com.example.projectitanes.models;

public class Lugar {
    private int id;
    private int idPaquete;
    private String nombre;
    private String descripcion;
    private String photoURI;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPhotoURI() {
        return photoURI;
    }

    public void setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
    }
}
