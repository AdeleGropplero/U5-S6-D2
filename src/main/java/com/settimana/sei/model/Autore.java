package com.settimana.sei.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "autori")
public class Autore {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar; //https://ui-avatars.com/api/?name=Mario+Rossi

    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> post;

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }

    @Override
    public String toString() {
        return "\n \nAutore{" +
                "\nid= " + id + '\n' +
                "nome= " + nome + '\n' +
                "cognome= " + cognome + '\n' +
                "email= " + email + '\n' +
                "dataNascita= " + dataNascita + '\n' +
                "avatar= " + avatar + '\n' +
                '}';
    }
}
