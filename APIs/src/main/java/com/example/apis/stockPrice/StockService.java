package com.example.apis.stockPrice;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

public class StockService {

    public static Stock getStock(String stockName) throws IOException {
        return YahooFinance.get(stockName);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getStock("GOOG"));
    }
}
