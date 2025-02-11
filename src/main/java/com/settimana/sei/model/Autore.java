package com.settimana.sei.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

public class Autore {
    private static int count = 1;
    private long id = count ++;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar; //https://ui-avatars.com/api/?name=Mario+Rossi

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {
        //this.id = count++;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }

    public Autore() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Autore.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
