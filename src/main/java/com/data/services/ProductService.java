package com.data.services;

import java.util.List;

import com.data.models.Product;

public interface ProductService {

	Product addProductToCategory(Product product, long idCategory);

	Product editProduct(Product product, long id);

	Product findProductById(long id);

	void deleteProduct(long id);

	List<Product> findAllProducts();

	List<Product> findProductsForCategory(long idCategory);

//	Product getProduct(Long id);
}
