package com.portal.apiCarros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.apiCarros.client.CarPostStoreClient;
import com.portal.apiCarros.dto.CarPostDTO;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {
	
	@Autowired
	CarPostStoreClient carPostStoreClient;

	@Override
	public List<CarPostDTO> getCarsForSale() {
		return carPostStoreClient.carForSaleClient();
	}

	@Override
	public void changeCarForSale(CarPostDTO carPost, String id) {
		carPostStoreClient.changeCarForSaleClient(carPost, id);
	}

	@Override
	public void removeCarForSale(String id) {
		carPostStoreClient.deleteCarForSaleClient(id);
	}
	
}
