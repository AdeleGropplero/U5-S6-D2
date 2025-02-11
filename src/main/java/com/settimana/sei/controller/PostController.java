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

    @GetMapping(value = "/posts")
    public List<Post> getAllPost(){
        return posts;
    }

    // POSTMAN --> http://localhost:8080/post/nuovoPost
    @PostMapping("/nuovoPost")
    @ResponseStatus(HttpStatus.CREATED)
    public String nuovoPost(@RequestBody Post post){
        posts.add(post);
        return "Post Aggiunto con successo\n" + post;
    }

    @GetMapping(value = "/getId/{id}", produces = "application/json") // consumes = che tipo di dato ci aspettiamo   // produces -> che tipo di dato diamo
    public String getIdPost(long id){
        return "Ecco il post con id " + id + "\n";
    }

/*    @GetMapping(value = "/getId/{id}", consumes = "application/json", produces = "application/json") // consumes = che tipo di dato ci aspettiamo   // produces -> che tipo di dato diamo
    public String getIdPost(long id){
        return "Ecco il post con id " + id + "\n";
    }*/

    @PutMapping("/update")
    public String updatePost(){
        return "Funzione updatePost terminata con successo";
    }

    @DeleteMapping("/cancella")
    public String deletePost(){
        return "Funzione deletePost terminata con successo";
    }


}
