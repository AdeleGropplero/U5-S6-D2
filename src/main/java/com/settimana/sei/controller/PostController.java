package com.settimana.sei.controller;

import com.settimana.sei.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //non necessita di @ResponseBody, da usare da ora in avanti
@RequestMapping("/post")
public class PostController {

    private List<Post> posts = new ArrayList<>();

    @GetMapping(value = "")
    public List<Post> getAllPost(){
        return posts;
    }

    // POSTMAN --> http://localhost:8080/post/nuovoPost
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String nuovoPost(@RequestBody Post post){
        posts.add(post);
        return "Post Aggiunto con successo\n" + post;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public Post getIdPost(@PathVariable Long id) {
        // Cerca il post con l'ID
        Post post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        return post;  // Ritorna direttamente il post
    }

    @PutMapping("/{id}")
    public Post updateById(@PathVariable Long id, @RequestBody Post updatePost){
        Post post = posts.stream().filter(p -> p.getId() == id ).findFirst().orElse(null);

        if (post == null) {
            throw new RuntimeException("Post con ID " + id + " non trovato"); // Oppure usa un'eccezione personalizzata
        }

        // Aggiorna solo i campi non nulli
        if (updatePost.getCategoria() != null) {
            post.setCategoria(updatePost.getCategoria());
        }
        if (updatePost.getTitolo() != null) {
            post.setTitolo(updatePost.getTitolo());
        }
        if (updatePost.getContenuto() != null) {
            post.setContenuto(updatePost.getContenuto());
        }
        if (updatePost.getTempoDiLettura() > 0) {
            post.setTempoDiLettura(updatePost.getTempoDiLettura());
        }

/*        post.setCategoria(updatePost.getCategoria());
        post.setTitolo(updatePost.getTitolo());
        post.setContenuto(updatePost.getContenuto());
        post.setTempoDiLettura(updatePost.getTempoDiLettura());*/

        return post;  // Restituisco il post aggiornato
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id){
        Post post = posts.stream().filter(p -> p.getId() == id ).findFirst().orElse(null);
        posts.remove(post);
        return "Post rimosso con successo. \nElemento rimosso: \n" + post;
    }

    @PostMapping("/postMultipli")
    @ResponseStatus(HttpStatus.CREATED)
    public String postMultipli(@RequestBody List<Post> newPosts) {
        posts.addAll(newPosts);  // Aggiunge tutti i post ricevuti alla lista esistente
        return "Post Aggiunti con successo\n" + newPosts + "\n";
    }

/*    @GetMapping(value = "/getId/{id}", consumes = "application/json", produces = "application/json") // consumes = che tipo di dato ci aspettiamo   // produces -> che tipo di dato diamo
    public String getIdPost(long id){
        return "Ecco il post con id " + id + "\n";
    }*/


/* Da aggiungere tutti insieme con l'ultimo metodo creato.
[
    {
        "categoria": "Cucina",
        "titolo": "La Carbonara Perfetta",
        "contenuto": "Uova, guanciale, pecorino e pepe: la ricetta definitiva per un piatto senza tempo.",
        "tempoDiLettura": 5
    },
    {
        "categoria": "Tecnologia",
        "titolo": "Intelligenza Artificiale: Minaccia o Opportunità?",
        "contenuto": "L'AI sta rivoluzionando il mondo del lavoro e la nostra quotidianità, ma siamo pronti?",
        "tempoDiLettura": 7
    },
    {
        "categoria": "Moda",
        "titolo": "Come Creare un Outfit Perfetto",
        "contenuto": "Consigli pratici per abbinare colori e accessori con stile.",
        "tempoDiLettura": 6
    },
    {
        "categoria": "Fitness",
        "titolo": "Allenamento HIIT per Bruciare Grassi",
        "contenuto": "Ecco una guida per un workout intenso e veloce da fare ovunque.",
        "tempoDiLettura": 8
    },
    {
        "categoria": "Cucito",
        "titolo": "Riparare un Buco nei Jeans",
        "contenuto": "Metodi facili e veloci per dare nuova vita ai tuoi capi preferiti.",
        "tempoDiLettura": 4
    },
    {
        "categoria": "Economia",
        "titolo": "Inflazione e Risparmio: Cosa Fare?",
        "contenuto": "Strategie intelligenti per proteggere i tuoi risparmi dall'inflazione.",
        "tempoDiLettura": 9
    },
    {
        "categoria": "Cinema",
        "titolo": "I 10 Film da Vedere Assolutamente",
        "contenuto": "Dal classico al contemporaneo: una lista di pellicole imperdibili.",
        "tempoDiLettura": 6
    },
    {
        "categoria": "Salute",
        "titolo": "Digiuno Intermittente: Pro e Contro",
        "contenuto": "Un'analisi basata su studi scientifici per capire se fa per te.",
        "tempoDiLettura": 7
    },
    {
        "categoria": "Viaggi",
        "titolo": "Le Mete più Sottovalutate d’Europa",
        "contenuto": "Scopri destinazioni incredibili lontano dal turismo di massa.",
        "tempoDiLettura": 8
    },
    {
        "categoria": "Scienza",
        "titolo": "Esistono gli Alieni? Le Ultime Scoperte",
        "contenuto": "Nuove ricerche e teorie sul mistero più affascinante dell’universo.",
        "tempoDiLettura": 10
    }
]
*/

}
