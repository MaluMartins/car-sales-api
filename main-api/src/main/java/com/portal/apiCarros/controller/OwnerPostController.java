package com.portal.apiCarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.apiCarros.dto.OwnerPostDTO;
import com.portal.apiCarros.service.OwnerPostService;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {
	@Autowired
	private OwnerPostService ownerPostService; 
	
	@PostMapping
	public ResponseEntity createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
		ownerPostService.createOwnerCar(ownerPostDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}






