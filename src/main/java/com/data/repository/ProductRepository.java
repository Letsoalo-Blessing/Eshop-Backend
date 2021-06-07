/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.data.models.Product;
/**
 *
 * @author Blessing
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

	 @Query("SELECT p FROM Product p WHERE p.name LIKE :n")
	    List<Product> findByName(@Param("n") String name);
}
