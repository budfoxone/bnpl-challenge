package com.bnpl.challenge.controller;

import com.bnpl.challenge.model.RequestDto;
import com.bnpl.challenge.model.ResponseDto;
import com.bnpl.challenge.model.StockProfit;
import com.bnpl.challenge.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/stockprice")
@CrossOrigin
@Slf4j
public class StockPriceController {

    StockService stockService;

    public StockPriceController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/bestvalue")
    public ResponseDto getBuyAndSellValue(@RequestBody RequestDto requestDto)  {

        int[] stockPrices = stockService.extractStockPrices(requestDto);
        StockProfit profit = stockService.getBuyAndSellValue(stockPrices);

        return ResponseDto.builder()
                .buyValue(profit.getBuyValue())
                .sellValue(profit.getSellValue())
                .maxProfit(profit.getMaxProfit())
                .request(requestDto)
                .processedDateTime(LocalDateTime.now())
                .build();

    }


}
