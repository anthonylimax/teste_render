package atividade_marcio_03.com.example.atividade_marcio_03.repositories;

import org.springframework.stereotype.Repository;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Category;
import atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;



@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void delete(Category category) {
        if (entityManager.contains(category)) {
            entityManager.remove(category);
        } else {
            entityManager.remove(entityManager.merge(category));
        }
    }

    @Override
    public Category findByName(String name) {
        return entityManager.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class)
                            .setParameter("name", name)
                            .getSingleResult();
    }
}
