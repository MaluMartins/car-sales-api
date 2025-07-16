package com.store.car.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;

@Service
public class CarPostServiceImpl implements CarPostService {
	
	@Autowired
	CarPostRepository carPostRepository;
	
	@Autowired
	OwnerPostRepository ownerPostRepository;

	@Override
	public void newPostDetails(CarPostDTO carPostDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CarPostDTO> getCarSales() {
		List<CarPostDTO> listCarSales = new ArrayList<>();
		carPostRepository.findAll().forEach(item-> {
				listCarSales.add(mapCarEntityToDTO(item));
				});
		
		return listCarSales;
	}

	@Override
	public void changeCarSale(CarPostDTO carPostDTO, Long postId) {
		carPostRepository.findById(postId).ifPresentOrElse(item -> {
			item.setDescription(carPostDTO.getDescription());
			item.setContact(carPostDTO.getContact());
			item.setPrice(carPostDTO.getPrice());
			item.setBrand(carPostDTO.getBrand());
			item.setEngine(carPostDTO.getEngineVersion());
			item.setModel(carPostDTO.getModel());
			
			carPostRepository.save(item);
		}, () -> {
			throw new NoSuchElementException();
		});
		
	}

	@Override
	public void removeCarSale(Long postId) {
		carPostRepository.deleteById(postId);
	}
	
	private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity) { //mapear(converter) entidade para o DTO
		return CarPostDTO.builder()
				.brand(carPostEntity.getBrand())
				.city(carPostEntity.getCity())
				.contact(carPostEntity.getContact())
				.createdDate(carPostEntity.getCreatedDate())
				.description(carPostEntity.getDescription())
				.engineVersion(carPostEntity.getEngine())
				.model(carPostEntity.getModel())
				.price(carPostEntity.getPrice())
				.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
