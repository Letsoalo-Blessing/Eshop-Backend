package com.data.implement;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.data.models.Category;
import com.data.models.Product;
import com.data.repository.CategoryRepository;
import com.data.repository.ProductRepository;
import com.data.services.ProductService;

@Transactional
@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Product addProductToCategory(Product product, long idCategory) {
		Category category = categoryRepository.findById(idCategory).orElse(null);
		category.addProductToCategory(product);
		return productRepository.save(product);
	}
	
	@Override
	public Product editProduct(Product product, long id) {
		Product existProduct = productRepository.findById(id).orElse(null);
		existProduct.setName(product.getName());
		existProduct.setDescription(product.getDescription());
		existProduct.setPictureUrl(product.getPictureUrl());
		existProduct.setPrice(product.getPrice());
		return productRepository.save(existProduct);
	}
	
	@Override
	public Product findProductById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> findProductsForCategory(long idCategory) {
		Category category = categoryRepository.findById(idCategory).orElse(null);
		return category.getProducts();
	}
}
