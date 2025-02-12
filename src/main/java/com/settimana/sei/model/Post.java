package com.settimana.sei.model;

import org.springframework.stereotype.Component;


@Component

public class Post {
    private static int count = 1;
    private long id = count ++;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Integer tempoDiLettura;

    //private Autore autore;

    public Post(String categoria, String titolo, String contenuto, Integer tempoDiLettura) {
       // this.id = count++;
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/300";
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }

    public Post() {
    }

    public static int getCount() {
        return count;
    }

    public long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getCover() {
        return cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public Integer getTempoDiLettura() {
        return tempoDiLettura;
    }

    public static void setCount(int count) {
        Post.count = count;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void setTempoDiLettura(Integer tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    @Override
    public String toString() {
        return "\n \nPost{" +
                "\nid= " + id + '\n' +
                "categoria= " + categoria + '\n' +
                "titolo= " + titolo + '\n' +
                "cover= " + cover + '\n' +
                "contenuto= " + contenuto + '\n' +
                "tempoDiLettura= " + tempoDiLettura +
                '}';
    }
}
