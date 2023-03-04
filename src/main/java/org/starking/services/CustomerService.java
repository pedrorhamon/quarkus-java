package org.starking.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.starking.dtos.CustomerDTO;
import org.starking.entities.CustomerEntity;
import org.starking.repositories.CustomerRepository;

@ApplicationScoped
public class CustomerService {

	@Inject
	private CustomerRepository customerRepository;
	
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> customers = new ArrayList<>();
		
		this.customerRepository.findAll().stream().forEach(item -> {
			customers.add(mapCustomerEntityToDTO(item));
		});
		return customers;
	}
	
	public void createNewCustomer(CustomerDTO dto) {
		this.customerRepository.persist(mapCustomerDTOToModel(dto));
	}
	
	private CustomerEntity mapCustomerDTOToModel(CustomerDTO dto) {
		CustomerEntity model = new CustomerEntity();
		
		model.setAddress(dto.getAddress());
		model.setAge(dto.getAge());
		model.setEmail(dto.getEmail());
		model.setName(dto.getName());
		model.setPhone(dto.getPhone());
		
		return model;
	} 
	
	private CustomerDTO mapCustomerEntityToDTO(CustomerEntity entity) {
		CustomerDTO dto = new CustomerDTO();
		
		dto.setAddress(entity.getAddress());
		dto.setAge(entity.getAge());
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		
		return dto;
	}
}
