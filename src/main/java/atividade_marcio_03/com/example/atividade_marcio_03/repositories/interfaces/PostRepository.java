package atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces;

import java.util.List;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Post;

public interface PostRepository {
    Post findById(Long id);
    List<Post> findAll();
    void save(Post post);
    void merge(Post post);
    void delete(Post post);
    List<Post> findByUserId(Long userId);
}
