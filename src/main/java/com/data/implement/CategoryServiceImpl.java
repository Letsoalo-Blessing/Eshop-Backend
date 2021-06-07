package com.data.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.data.models.Category;
import com.data.models.User;
import com.data.repository.CategoryRepository;
import com.data.repository.UserRepository;
import com.data.services.CategoryService;

@Transactional
@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryDao;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Category editCategory(Category category, long id) {
		Category existsCategory = categoryDao.findById(id).orElse(null);
		existsCategory.setName(category.getName());
		return categoryDao.save(existsCategory);
	}

	@Override
	public Category findCategoryById(long id) {
		return categoryDao.findById(id).orElse(null);
	}

	@Override
	public void deleteCategory(long id) {
		categoryDao.deleteById(id);
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryDao.findAll();
	}
	 
	public List<Category> findCategoriesForUser(long id) {
		User user = userRepository.findById(id).orElse(null);
		return user.getCategories();
	}
}
