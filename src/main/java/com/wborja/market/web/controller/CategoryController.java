package com.wborja.market.web.controller;

import com.wborja.market.domain.Category;
import com.wborja.market.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int categoryId){
        return new ResponseEntity(categoryService.getCategory(categoryId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity(categoryService.save(category), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Category> save(@PathVariable("id") int categoryId){
        if(categoryService.delete(categoryId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
