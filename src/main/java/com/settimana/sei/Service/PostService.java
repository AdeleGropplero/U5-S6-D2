package com.settimana.sei.Service;

import com.settimana.sei.model.Post;
import com.settimana.sei.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Post> getAllPost(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Optional<Post> getById(Long id){
        return postRepository.findById(id);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public void AddAll(List<Post> posts){
        postRepository.saveAll(posts);
    }
}
