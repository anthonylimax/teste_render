package atividade_marcio_03.com.example.atividade_marcio_03.repositories;

import org.springframework.stereotype.Repository;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Comment;
import atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces.CommentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Comment findById(Long id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public List<Comment> findAll() {
        return entityManager.createQuery("from Comment", Comment.class).getResultList();
    }

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void delete(Comment comment) {
        if (entityManager.contains(comment)) {
            entityManager.remove(comment);
        } else {
            entityManager.remove(entityManager.merge(comment));
        }
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return entityManager.createQuery("SELECT c FROM Comment c WHERE c.post.id = :postId", Comment.class)
                .setParameter("postId", postId)
                .getResultList();
    }

    @Override
    public List<Comment> findByUserId(Long userId) {
        return entityManager.createQuery("SELECT c FROM Comment c WHERE c.user.id = :userId", Comment.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
