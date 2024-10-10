package atividade_marcio_03.com.example.atividade_marcio_03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Post;
import atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces.PostRepository;

import java.util.List;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id);
        if (post != null) {
            postRepository.delete(post);
        }
    }

    public List<Post> findByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
