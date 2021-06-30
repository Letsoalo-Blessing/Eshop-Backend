package com.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.services.ProductService;
import com.data.models.*;
import com.data.repository.ProductRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product/")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("getAllProducts")
	public List<Product> getAllProduct() {

		return productservice.findAllProducts();
	}

	@GetMapping("findProductsForCategory/{idCategory}")
	List<Product> findProductsForCategory(@PathVariable long idCategory) {

		return productservice.findProductsForCategory(idCategory);
	}

	@GetMapping("findProductById/{id}")
	Product findProductById(@PathVariable long id) {

		return productservice.findProductById(id);
	}
	
	@GetMapping("findByName/{name}")
	List<Product> findByName(@PathVariable String name){
		
		return productRepository.findByName("%"+name+"%");
	}
	
	@PostMapping("addProductToCategory/{idCategory}")
	Product addProductToCategory (@RequestBody Product product, @PathVariable long idCategory) {
		
		return productservice.addProductToCategory(product, idCategory);
	}
	
	@PutMapping("editProduct/{id}")
	Product editProduct(@RequestBody Product product, @PathVariable long id) {
		
		return productservice.editProduct(product, id);
	}
}