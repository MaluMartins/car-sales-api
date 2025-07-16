package com.portal.apiCarros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.apiCarros.client.CarPostStoreClient;
import com.portal.apiCarros.dto.OwnerPostDTO;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{
	
	@Autowired
	private CarPostStoreClient carPostStoreClient;

	@Override
	public void createOwnerCar(OwnerPostDTO ownerPostDTo) {
		carPostStoreClient.ownerPostsClient(ownerPostDTo);		
	}

}
