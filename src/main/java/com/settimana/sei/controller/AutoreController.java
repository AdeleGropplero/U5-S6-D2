package com.settimana.sei.controller;

import com.settimana.sei.Service.AutoreService;
import com.settimana.sei.model.Autore;
import com.settimana.sei.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController //non necessita di @ResponseBody, da usare da ora in avanti
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

   // private List<Autore> autori = new ArrayList<>();

//    public static int id = 1; in alternativa al farlo nella classe.

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String inserisciAutore(@RequestBody Autore newAutore){
        String nome = newAutore.getNome();
        String cognome = newAutore.getCognome();
        String email = newAutore.getEmail();
        LocalDate dataDiNascita = newAutore.getDataNascita();

        autoreService.insertAutore(newAutore);
        //autori.add(autore);
//        autore.setId(id);
//        id++;
        return "Autore aggiunto con successo\n" + newAutore;
    }

    @PostMapping("/autoriMultipli")
    @ResponseStatus(HttpStatus.CREATED)
    public String autoriMultipli(@RequestBody List<Autore> newAutori) {
       autoreService.AddAll(newAutori);
        // autori.addAll(newAutori);
        return "Post Aggiunti con successo\n" + newAutori + "\n";
    }

    @GetMapping(value = "")
    public List<Autore> getAllAutori(){
        return /*autori*/ autoreService.getAllAutore();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Autore getAutore(@PathVariable Long id) {
        // Cerca l'autore con l'ID
        //Autore autore = autori.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        return /*autore*/ autoreService.getById(id).orElseThrow(() -> new RuntimeException("Autore con ID " + id + " non trovato"));  // Ritorna direttamente il autore
    }

    @PutMapping("/{id}")
    public Autore updateById(@PathVariable Long id, @RequestBody Autore updateAutore){
        //Autore autore = autori.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        Autore autore = autoreService.getById(id).orElseThrow(() -> new RuntimeException("Autore con ID " + id + " non trovato"));

        // Aggiorna solo i campi non nulli
        if (updateAutore.getNome() != null) {
            autore.setNome(updateAutore.getNome());
        }
        if (updateAutore.getCognome() != null) {
            autore.setCognome(updateAutore.getCognome());
        }
        if (updateAutore.getEmail() != null) {
            autore.setEmail(updateAutore.getEmail());
        }
        if (updateAutore.getDataNascita() != null) {
            autore.setDataNascita(updateAutore.getDataNascita());
        }
       /*autore.setNome(updateAutore.getNome());
        autore.setCognome(updateAutore.getCognome());
        autore.setEmail(updateAutore.getEmail());
        autore.setDataNascita(updateAutore.getDataNascita());*/

        return autore;  // Restituisco il autore aggiornato
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id){
        //Autore autore = autori.stream().filter(p -> p.getId() == id ).findFirst().orElse(null);
       // autori.remove(autore);
        autoreService.deleteAutore(id);
        return "Autore rimosso con successo. \nElemento rimosso: \n" + id;
    }


}

/*[
    {
        "nome": "Mario",
        "cognome": "Rossi",
        "email": "mario.rossi@email.com",
        "dataNascita": "1985-03-15"
    },
    {
        "nome": "Luigi",
        "cognome": "Verdi",
        "email": "luigi.verdi@email.com",
        "dataNascita": "1990-07-21"
    },
    {
        "nome": "Anna",
        "cognome": "Bianchi",
        "email": "anna.bianchi@email.com",
        "dataNascita": "1988-12-30"
    },
    {
        "nome": "Giuseppe",
        "cognome": "Gialli",
        "email": "giuseppe.gialli@email.com",
        "dataNascita": "1982-05-10"
    },
    {
        "nome": "Claudia",
        "cognome": "Neri",
        "email": "claudia.neri@email.com",
        "dataNascita": "1992-02-28"
    },
    {
        "nome": "Federico",
        "cognome": "Turchi",
        "email": "federico.turchi@email.com",
        "dataNascita": "1989-08-17"
    },
    {
        "nome": "Martina",
        "cognome": "Rossi",
        "email": "martina.rossi@email.com",
        "dataNascita": "1995-01-22"
    },
    {
        "nome": "Luca",
        "cognome": "Verdi",
        "email": "luca.verdi@email.com",
        "dataNascita": "1987-09-11"
    },
    {
        "nome": "Giulia",
        "cognome": "Bianchi",
        "email": "giulia.bianchi@email.com",
        "dataNascita": "1993-04-06"
    },
    {
        "nome": "Marco",
        "cognome": "Gialli",
        "email": "marco.gialli@email.com",
        "dataNascita": "1990-06-14"
    }
]
*/
