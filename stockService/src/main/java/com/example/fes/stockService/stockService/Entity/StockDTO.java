package com.example.fes.stockService.stockService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {

    private List<Stock> stockPriceList;
    private double min;
    private double max;
    private double average;
}
