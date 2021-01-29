package com.wborja.market.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wborja.market.domain.Purchase;
import com.wborja.market.domain.service.PurchaseService;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Purchase>> getAll(){
		return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") int clientId){
		return purchaseService.getByClient(clientId)
				.map(purchaseList -> new ResponseEntity<>(purchaseList, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Purchase> save(Purchase purchase){
		return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
	}
}
