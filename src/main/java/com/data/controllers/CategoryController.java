/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.models.Category;
import com.data.services.CategoryService;

/**
 *
 * @author Blessing
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;

	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {

		return categoryservice.findAllCategories();
	}

	@GetMapping("/findCategoryById/{id}")
	Category findCategoryById(@PathVariable long id) {
		return categoryservice.findCategoryById(id);
	}

	@DeleteMapping("/deleteCategory/{}")
	void deletCategory(@PathVariable long id) {
		categoryservice.deleteCategory(id);
	}
	
	@GetMapping("/findCategoriesForUser/{id}")
	List<Category> findCategoriesForUser(@PathVariable long id) {
		return categoryservice.findCategoriesForUser(id);
	}
}
