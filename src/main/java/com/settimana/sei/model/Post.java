package com.settimana.sei.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Integer tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;

    public Post(String categoria, String titolo, String contenuto, Integer tempoDiLettura, Autore autore) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/300";
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.autore = autore;
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
