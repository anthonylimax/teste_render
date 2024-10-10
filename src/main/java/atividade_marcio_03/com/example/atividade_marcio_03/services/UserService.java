package atividade_marcio_03.com.example.atividade_marcio_03.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import atividade_marcio_03.com.example.atividade_marcio_03.models.Usuario;
import atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces.UserRepository;

import java.util.List;

@Service
public class UserService{
    
    @Autowired
    private UserRepository userRepository;


    public Usuario findById(Long id) {
        return userRepository.findById(id);
    }

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public void save(Usuario user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        Usuario user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
