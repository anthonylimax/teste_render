package atividade_marcio_03.com.example.atividade_marcio_03.repositories;
import atividade_marcio_03.com.example.atividade_marcio_03.models.Usuario;
import atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces.UserRepository;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario findById(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return entityManager.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @Override
    public void save(Usuario user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Usuario user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
    }

    @Override
    public Usuario findByEmail(String email) {
        return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                            .setParameter("email", email)
                            .getSingleResult();
    }
}
