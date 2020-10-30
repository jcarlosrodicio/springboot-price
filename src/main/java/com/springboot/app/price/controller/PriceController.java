package com.springboot.app.price.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.price.models.entity.Price;
import com.springboot.app.price.service.PriceService;

@RestController
public class PriceController {
	
	@Autowired
	private PriceService priceService;

	@GetMapping("/price/{date}/product/{productId}/brand/{brandId}")
	public Price price(@PathVariable
					   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    					Calendar date, 
    					@PathVariable Long productId,
    					@PathVariable Long brandId) {
		return priceService.price(date, productId, brandId);
	}
}
