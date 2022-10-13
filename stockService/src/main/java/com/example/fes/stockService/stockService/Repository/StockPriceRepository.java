package com.example.fes.stockService.stockService.Repository;

import java.util.Date;
import java.util.List;

import com.example.fes.stockService.stockService.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends JpaRepository<Stock, String>{

	@Query(value = "SELECT * FROM Stock WHERE company_code = ?1 AND CAST(stock_date AS Date) BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Stock> fetchStockPrice(String companyCode, Date startDate, Date endDate);

}
