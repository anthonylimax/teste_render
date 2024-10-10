package atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces;

import java.util.List;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Comment;

public interface CommentRepository {
    Comment findById(Long id);
    List<Comment> findAll();
    void save(Comment comment);
    void delete(Comment comment);
    List<Comment> findByPostId(Long postId);
    List<Comment> findByUserId(Long userId);
}