package com.fresco.ecommerce.controllers;

import com.fresco.ecommerce.config.JwtUtil;
import com.fresco.ecommerce.models.User;
import com.fresco.ecommerce.repo.ProductRepo;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fresco.ecommerce.models.Product;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/auth/seller")
public class SellerController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private ProductRepo productRepo;

	@PostMapping("/product")
	@Transactional
	public ResponseEntity<Object> postProduct(@RequestHeader(name = "JWT") String jwt, @RequestBody Product product)  {
		product.setSeller(jwtUtil.getUser(jwt));
		Product response = productRepo.saveAndFlush(product);
		return ResponseEntity.status(HttpStatus.CREATED).body("http://localhost/api/auth/seller/product/" + response.getProductId());
	}

	@GetMapping("/product")
	public ResponseEntity<Object> getAllProducts() {
		return ResponseEntity.ok(productRepo.findAll());
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<Object> getProduct() {
		return null;
	}

	@PutMapping("/product")
	public ResponseEntity<Object> putProduct() {
		return null;
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Product> deleteProduct() {
		return null;
	}
}