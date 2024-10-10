package atividade_marcio_03.com.example.atividade_marcio_03.repositories.interfaces;

import java.util.List;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Category;


public interface CategoryRepository {
    Category findById(Long id);
    List<Category> findAll();
    void save(Category category);
    void delete(Category category);
    Category findByName(String name);
}
