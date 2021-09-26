package com.tiago.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.tiago.entities.Product;
import com.tiago.repositories.ProductsRepository;

@Service
@Profile("products")
public class ProductService {

	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Product> findAll(){
		return this.productsRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productsRepository.findById(id);
		return obj.get();
	}
}
