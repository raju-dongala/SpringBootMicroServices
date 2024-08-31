package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Address;
import com.app.response.AddressResponse;
import com.app.service.AddressServiceImpl;

@RestController
@RequestMapping("/v1/api/address")
public class AddressRestController {
	
	@Autowired
	AddressServiceImpl addressImpl;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AddressResponse> getAddressBasedOnId(@PathVariable Integer id){
		AddressResponse addressBasedOnId = addressImpl.getAddressBasedOnId(id);
		return new ResponseEntity<AddressResponse>(addressBasedOnId,HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<AddressResponse> createAddressDetails(@RequestBody Address addr){
		
		AddressResponse createAddr = addressImpl.createAddressDetails(addr);
		return new ResponseEntity<AddressResponse>(createAddr,HttpStatus.CREATED);
	}
	
	

}
