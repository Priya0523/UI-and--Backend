package com.example.fes.stockService.stockService.Service;

import com.example.fes.stockService.stockService.Entity.Stock;
import com.example.fes.stockService.stockService.Entity.StockDTO;
import com.example.fes.stockService.stockService.Exception.StockPriceException;

import java.util.Date;

public interface StockService {

	void addStockPrice(Stock stockPrice) throws StockPriceException;

	StockDTO fetchStockPriceList(String companyCode, Date startDate, Date endDate) throws StockPriceException;

}
