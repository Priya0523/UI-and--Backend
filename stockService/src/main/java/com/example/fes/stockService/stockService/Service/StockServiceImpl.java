package com.example.fes.stockService.stockService.Service;

import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import com.example.fes.stockService.stockService.Entity.Stock;
import com.example.fes.stockService.stockService.Entity.StockDTO;
import com.example.fes.stockService.stockService.Exception.StockPriceException;
import com.example.fes.stockService.stockService.Repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockPriceRepository stockPriceRepository;

	@Override
	public void addStockPrice(Stock stockPrice) throws StockPriceException {
		stockPrice.setStockDate(new Date());
		stockPriceRepository.save(stockPrice);
	}

	@Override
	public StockDTO fetchStockPriceList(String companyCode, Date startDate, Date endDate) throws StockPriceException{

		List<Stock> stockPriceList = stockPriceRepository.fetchStockPrice(companyCode, startDate, endDate);

		StockDTO stockPriceDTO = new StockDTO();
		if(!CollectionUtils.isEmpty(stockPriceList)) {
			DoubleSummaryStatistics stats = stockPriceList.stream()
	                .mapToDouble((x) -> x.getStockPriceValue())
	                .summaryStatistics();
			stockPriceDTO.setAverage(stats.getAverage());
			stockPriceDTO.setMin(stats.getMin());
			stockPriceDTO.setMax(stats.getMax());
		}
		stockPriceDTO.setStockPriceList(stockPriceList);
		return stockPriceDTO;
	}

}
