package com.wborja.market.persistence;

import com.wborja.market.domain.Category;
import com.wborja.market.domain.repository.CategoryRepository;
import com.wborja.market.persistence.crud.CategoriaCrudRepository;
import com.wborja.market.persistence.entity.Categoria;
import com.wborja.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return categoryMapper.toCategories((List<Categoria>) categoriaCrudRepository.findAll());
    }

    @Override
    public Optional<Category> getById(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(category -> categoryMapper.toCategory(category));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = categoryMapper.toCategoria(category);
        return categoryMapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
