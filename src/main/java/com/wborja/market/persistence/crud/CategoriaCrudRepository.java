package com.wborja.market.persistence.crud;

import com.wborja.market.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {

}
