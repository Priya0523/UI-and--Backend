package com.example.fes.stockService.stockService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_price_id")
    private int stockPriceId;

    @Column(name = "company_code", nullable = false)
    private String companyCode;

    @Column(name = "stock_price", nullable = false)
    private double stockPriceValue;

    @Column(name = "stock_date")
    private Date stockDate;
}
