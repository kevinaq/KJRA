package com.example.kjra.model;

public class Biblia {
    private String nombre;
    private int capitulo;
    private int versiculo;
    private String image;
    private int id;

    public Biblia() {
    }

    public Biblia(String nombre, int capitulo, int versiculo, String image, int id) {
        this.nombre = nombre;
        this.capitulo = capitulo;
        this.versiculo = versiculo;
        this.image = image;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    public int getVersiculo() {
        return versiculo;
    }

    public void setVersiculo(int versiculo) {
        this.versiculo = versiculo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
