package com.bnpl.challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StockServiceTest {

    StockService stockService;

    @BeforeEach
    void init() {
        stockService = new StockService();
    }

    @Test
    public void getMaxProfit() {

//        int[] stockPrices = {10, 7, 5, 8, 11, 9};
//        assertThat(stockService.getMaxProfit(stockPrices)).isEqualTo(6);
//
//        int[] stockPrices2 = {};
//        assertThat(stockService.getMaxProfit(stockPrices2)).isEqualTo(0);
//
//        int[] stockPrices3 = {5, 11, 0, 2, 1};
//        assertThat(stockService.getMaxProfit(stockPrices3)).isEqualTo(6);
//
//        int[] stockPrices4 = {2, 4, 1};
//        assertThat(stockService.getMaxProfit(stockPrices4)).isEqualTo(2);
//
//        int[] stockPrices5 = {1, 3, 4, 20, 2};
//        assertThat(stockService.getMaxProfit(stockPrices5)).isEqualTo(19);
//
//        int[] stockPrices6 = {20, 17, 4, 18, 19};
//        assertThat(stockService.getMaxProfit(stockPrices6)).isEqualTo(15);
//
//        int[] stockPrices7 = {1, 11, 1, 12, 0, 1};
//        assertThat(stockService.getMaxProfit(stockPrices7)).isEqualTo(11);

        int[] stockPrices8 = {5};
        assertThat(stockService.getMaxProfit(stockPrices8)).isEqualTo(11);

        log.info("done");

    }

}
