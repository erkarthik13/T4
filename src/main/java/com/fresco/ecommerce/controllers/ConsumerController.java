package com.fresco.ecommerce.controllers;

import com.fresco.ecommerce.config.JwtUtil;
import com.fresco.ecommerce.models.User;
import com.fresco.ecommerce.repo.CartRepo;
import com.fresco.ecommerce.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/auth/consumer")
public class ConsumerController {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private JwtUtil jwtUtil;


	@GetMapping("/cart")
	public ResponseEntity<Object> getCart(@RequestHeader(name = "JWT") String jwt) {
		String username= jwtUtil.getUser(jwt).getUsername();
		return ResponseEntity.ok(cartRepo.findByUserUsername(username));
	}

	@PostMapping("/cart")
	public ResponseEntity<Object> postCart() {
		return null;
	}

	@PutMapping("/cart")
	public ResponseEntity<Object> putCart() {
		return null;
	}

	@DeleteMapping("/cart")
	public ResponseEntity<Object> deleteCart() {
		return null;
	}

}