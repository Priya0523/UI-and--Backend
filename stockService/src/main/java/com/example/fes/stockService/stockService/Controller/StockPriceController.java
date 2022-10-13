package com.example.fes.stockService.stockService.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.fes.stockService.stockService.Entity.Stock;
import com.example.fes.stockService.stockService.Entity.StockDTO;
import com.example.fes.stockService.stockService.Exception.StockPriceException;
import com.example.fes.stockService.stockService.Service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1.0/market/stock")
@CrossOrigin("http://localhost:4200/")
public class StockPriceController {
	
	Logger logger = LoggerFactory.getLogger(StockPriceController.class); 
	
	@Autowired
	StockService stockPriceService;

	@PostMapping("/add")
	public ResponseEntity<String> addStockPrice(@RequestBody Stock stockPrice) {
		try {
			stockPriceService.addStockPrice(stockPrice);
		}catch(StockPriceException e) {
			logger.error("Class StockPriceController: Failed to add stock Price");
		}
		return new ResponseEntity<>("Stock added", HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{companyCode}/{startDate}/{endDate}")
	public ResponseEntity<StockDTO> fetchStockPriceList(@PathVariable("companyCode") String companyCode,
														@PathVariable("startDate") String startDate,
														@PathVariable("endDate") String endDate) throws ParseException {
		StockDTO stockPriceDTO = null;
		try {
			stockPriceDTO = stockPriceService.fetchStockPriceList(companyCode, new SimpleDateFormat("yyyy-MM-dd").parse(startDate), new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch(StockPriceException e) {
			logger.error("Class StockPriceController: Failed to fetchStockPrice");
		}
		return new ResponseEntity<>(stockPriceDTO, HttpStatus.OK);
	}
	

}
