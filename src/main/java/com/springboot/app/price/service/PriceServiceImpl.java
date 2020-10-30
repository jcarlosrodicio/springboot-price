package com.springboot.app.price.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.price.error.PriceErrorException;
import com.springboot.app.price.models.entity.Price;
import com.springboot.app.price.models.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Price price(Calendar date, Long productId, Long brandId) {
		/**
		 * Se llama al repositorio y se busca, de los resultados, el Price con la prioridad más alta
		 */
		Price price = null;
		List<Price> listPrices = priceRepository.findAllWithDatetimeBetween(date, productId, brandId);
		if(listPrices != null &&  !listPrices.isEmpty()) {
			price = Collections.max(listPrices,
					Comparator.comparing(p -> p.getPriority()));
		}else {
			throw new PriceErrorException("No se ha encontrado ningún resultado");
		}
		return price;
	}

}
