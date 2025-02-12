package com.settimana.sei.Service;

import com.settimana.sei.model.Post;
import com.settimana.sei.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void insertPost(Post post){
        postRepository.save(post) ;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Optional<Post> getById(Long id){
        return postRepository.findById(id);
    }
}
