package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Address;
import com.app.exception.AddressNotFoundException;
import com.app.repo.AddressRepo;
import com.app.response.AddressResponse;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public AddressResponse getAddressBasedOnId(Integer id) {
		Address address = addressRepo.findById(id).orElseThrow(()-> new AddressNotFoundException("Address Not Found with Id "+id));
		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
		return addressResponse;
	}

	@Override
	public AddressResponse createAddressDetails(Address addr) {
		Address save = addressRepo.save(addr);
		AddressResponse addressResponse = modelMapper.map(save, AddressResponse.class);
		return addressResponse;
	}


}
