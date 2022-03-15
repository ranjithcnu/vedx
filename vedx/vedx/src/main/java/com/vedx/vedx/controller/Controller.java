package com.vedx.vedx.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedx.vedx.model.Restuser;

@RestController
@RequestMapping("/users")
public class Controller {
	
	Map<String,Restuser> allusers=new HashMap<>();
	
    @GetMapping
	public Collection<Restuser> getMethod() {
		return allusers.values();
		
	}
    @PostMapping
	public String postMethod(@RequestBody Restuser userdetails) {
    	Restuser addvalue=new Restuser();
    	addvalue.setOrderid(userdetails.getOrderid());
    	addvalue.setCustomer(userdetails.getCustomer());
    	addvalue.setAddress(userdetails.getAddress());
    	addvalue.setProduct(userdetails.getProduct());
    	addvalue.setDateoforder(userdetails.getDateoforder());
    	addvalue.setStatus(userdetails.getStatus());
    	allusers.put(userdetails.getOrderid(), addvalue);
		return "user added";
		
	}
    @PutMapping(path="/{orderid}")
	public String putMethod(@PathVariable String orderid,@RequestBody Restuser userdetails) {
    	if (allusers.containsKey(orderid)) {
    		Restuser addvalue=new Restuser();
    		addvalue.setOrderid(userdetails.getOrderid());
        	addvalue.setCustomer(userdetails.getCustomer());
        	addvalue.setAddress(userdetails.getAddress());
        	addvalue.setProduct(userdetails.getProduct());
        	addvalue.setDateoforder(userdetails.getDateoforder());
        	addvalue.setStatus(userdetails.getStatus());
        	allusers.put(orderid, addvalue);
    		return "Edit is done";
    	}
    	else 
    	{
    		return "order id not found";	
    	}
		
	}
    @DeleteMapping(path="/{orderid}")
	public String deleteMethod(@PathVariable String orderid) {
    	if (allusers.containsKey(orderid)) {
    		allusers.remove(orderid);
    		return "Removed successfully";
    	}
    	else {
		return "Data not matched or not found";
    	}
	}
}
