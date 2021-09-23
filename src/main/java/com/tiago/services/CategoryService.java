package com.tiago.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.tiago.entities.Category;
import com.tiago.repositories.CategoryRepository;

@Service
@Profile("products")
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRespository;
	
	public List<Category> findAll(){
		return categoryRespository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRespository.findById(id);
		return obj.get();
	}
}
