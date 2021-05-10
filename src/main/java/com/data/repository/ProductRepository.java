/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.models.Product;
/**
 *
 * @author Blessing
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findAll();
}
