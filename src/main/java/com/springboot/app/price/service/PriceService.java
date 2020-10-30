package com.springboot.app.price.service;

import java.util.Calendar;

import com.springboot.app.price.models.entity.Price;

public interface PriceService {

	public Price price(Calendar date, Long productId, Long brandId);
}
