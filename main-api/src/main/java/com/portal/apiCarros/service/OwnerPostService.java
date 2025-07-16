package com.portal.apiCarros.service;

import org.springframework.stereotype.Service;

import com.portal.apiCarros.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {

	void createOwnerCar(OwnerPostDTO ownerPostDTo);
	
}
