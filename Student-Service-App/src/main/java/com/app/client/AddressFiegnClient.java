package com.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.entity.AddressResponse;

@FeignClient(name="Address-Service-App",url = "http://localhost:8082/v1/api/address")
public interface AddressFiegnClient{
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AddressResponse> getAddressBasedOnId(@PathVariable Integer id);

}
