package com.portal.apiCarros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portal.apiCarros.dto.CarPostDTO;

@Service
public interface CarPostStoreService {

	List<CarPostDTO> getCarsForSale();
	
	void changeCarForSale(CarPostDTO carPost, String id);
	
	void removeCarForSale(String id);
}
