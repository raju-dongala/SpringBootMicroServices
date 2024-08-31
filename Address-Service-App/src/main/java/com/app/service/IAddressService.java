package com.app.service;

import com.app.entity.Address;
import com.app.response.AddressResponse;

public interface IAddressService {
	
	public AddressResponse getAddressBasedOnId(Integer id);
	
	public AddressResponse createAddressDetails(Address addr);

}
