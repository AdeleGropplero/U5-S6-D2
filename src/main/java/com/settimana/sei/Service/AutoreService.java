package com.settimana.sei.Service;

import com.settimana.sei.model.Autore;
import com.settimana.sei.model.Post;
import com.settimana.sei.repository.AutoreRepository;
import com.settimana.sei.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;


    public void insertAutore(Autore autore){
        autoreRepository.save(autore) ;
    }

    public List<Autore> getAllAutore(){
        return autoreRepository.findAll();
    }

    public Optional<Autore> getById(Long id){
        return autoreRepository.findById(id);
    }

    public void deleteAutore(Long id){
        autoreRepository.deleteById(id);
    }

    public void AddAll(List<Autore> autori){
        autoreRepository.saveAll(autori);
    }
}
