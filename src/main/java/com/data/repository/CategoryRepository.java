/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.data.models.Category;
/**
 *
 * @author Blessing
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findAll();
}
