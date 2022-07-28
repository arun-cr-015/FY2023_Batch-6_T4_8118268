package com.virtusa.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.project.dto.PaymentDto;

import com.virtusa.project.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payment/{id}")
	public PaymentDto payment(@PathVariable(value = "id") long id) {
		return paymentService.payment(id);
	}

}
