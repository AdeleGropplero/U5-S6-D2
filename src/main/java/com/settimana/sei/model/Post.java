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
    private int tempoDiLettura;

    public Post(String categoria, String titolo, String contenuto, int tempoDiLettura) {
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

    public int getTempoDiLettura() {
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

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoDiLettura=" + tempoDiLettura +
                '}';
    }
}
