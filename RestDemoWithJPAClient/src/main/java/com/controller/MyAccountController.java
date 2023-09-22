package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.data.Account;

@RestController
public class MyAccountController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/myAccount/{accno}")
	public Account getMyAccount(@PathVariable("accno") int accno) {
		String url="http://localhost:8083/accounts/"+accno;
	    final Account acc = restTemplate.getForObject(url, Account.class);
	    System.out.println(acc);
	    return acc;
	}

}
