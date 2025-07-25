package com.portal.apiCarros.client;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.portal.apiCarros.dto.CarPostDTO;
import com.portal.apiCarros.dto.OwnerPostDTO;

@Component
public class CarPostStoreClient {
	
	//URLs para acessar apis fora do microserviço atual
	private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
	private final String POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales";

	@Autowired
	RestTemplate restTemplate;
	
	public List<CarPostDTO> carForSaleClient() {
		ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI + "/cars", CarPostDTO[].class);
		return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
	}
	
	public void ownerPostsClient(OwnerPostDTO newUser) {
		restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
	}
	
	public void changeCarForSaleClient(CarPostDTO carPostDto, String id) {
		restTemplate.put(POSTS_STORE_SERVICE_URI + "/car/" + id, carPostDto, CarPostDTO.class);
	}
	
	public void deleteCarForSaleClient(String id) {
		restTemplate.delete(POSTS_STORE_SERVICE_URI + "/car/" + id);
	}

}









