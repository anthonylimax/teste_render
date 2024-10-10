package atividade_marcio_03.com.example.atividade_marcio_03.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Usuario;
import atividade_marcio_03.com.example.atividade_marcio_03.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Usuario user = userService.findById(id);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
                            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario userDetails) {
        Usuario user = userService.findById(id);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            // Atualize outros campos conforme necessário
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/email")
    public ResponseEntity<Usuario> getUserByEmail(@RequestParam String email) {
        Usuario user = userService.findByEmail(email);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK)
                            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
