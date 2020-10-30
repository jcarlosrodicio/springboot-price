package com.springboot.app.price.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.app.price.models.entity.Price;
import com.springboot.app.price.models.repository.PriceRepository;

@SpringBootTest
class PriceRepositoryTest {

	@Autowired
	private PriceRepository priceRepository;
	
	@Test
	void findPriceNotEmpty() throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 10:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Long productId = 35455L;
		Long brandId = 1L;
		List<Price> prices = this.priceRepository.findAllWithDatetimeBetween(calendar, productId, brandId);
		assertThat(prices).isNotEmpty();
	}
	
	@Test
	void findPriceEmpty() throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-06-14 10:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Long productId = 35455L;
		Long brandId = 1L;
		List<Price> prices = this.priceRepository.findAllWithDatetimeBetween(calendar, productId, brandId);
		assertThat(prices).isEmpty();
	}
}
