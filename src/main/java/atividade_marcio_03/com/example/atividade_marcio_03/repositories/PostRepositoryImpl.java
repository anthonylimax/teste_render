package atividade_marcio_03.com.example.atividade_marcio_03.repositories;

import org.springframework.stereotype.Repository;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Post;
import atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Post findById(Long id) {
        return entityManager.find(Post.class, id);
    }

    @Override
    public List<Post> findAll() {
        return entityManager.createQuery("from Post", Post.class).getResultList();
    }

    @Override
    public void save(Post post) {
        entityManager.persist(post);
    }
    @Override
    public void merge(Post post) {
        entityManager.merge(post);
    }

    @Override
    public void delete(Post post) {
        if (entityManager.contains(post)) {
            entityManager.remove(post);
        } else {
            entityManager.remove(entityManager.merge(post));
        }
    }


    @Override
    public List<Post> findByUserId(Long userId) {
        return entityManager.createQuery("SELECT p FROM Post p WHERE p.user.id = :userId", Post.class)
                            .setParameter("userId", userId)
                            .getResultList();
    }
}
