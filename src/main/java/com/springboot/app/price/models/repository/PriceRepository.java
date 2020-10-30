package com.springboot.app.price.models.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.app.price.models.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

	@Query(value = "select * from prices p where ?1 between p.start_date and end_date and p.product_id = ?2 and p.brand_id = ?3", nativeQuery = true)
	List<Price> findAllWithDatetimeBetween(Calendar date, Long productId, Long brandId);
}
