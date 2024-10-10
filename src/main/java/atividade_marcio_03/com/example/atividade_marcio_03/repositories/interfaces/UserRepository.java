package atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces;

import java.util.List;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Usuario;

public interface UserRepository {
    Usuario findById(Long id);
    List<Usuario> findAll();
    void save(Usuario user);
    void delete(Usuario user);
    Usuario findByEmail(String email);
}
