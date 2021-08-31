package com.bnpl.challenge.service;

import com.bnpl.challenge.model.RequestDto;
import com.bnpl.challenge.model.StockProfit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.stream.LongStream;

@Service
@Slf4j
public class StockService {

    public int getMaxProfit(int[] stockPrices) {
        // as per requirement, the method will return max profit
        StockProfit profit = getBuyAndSellValue(stockPrices);
        return profit.getMaxProfit();
    }

    public StockProfit getBuyAndSellValue(int[] stockPrices) {

        // I thought it will be best to get the buy price and sell price plus max profit in one method
        int minPrice = 0;
        int maxPrice = 0;
        int maxProfit = 0;

        if (stockPrices.length > 0) {
            int tmpProfit = 0;
            int tmpMinPrice = stockPrices.length > 0 ? stockPrices[0] : 0;
            for (int i =0; i<stockPrices.length; i++) {
                if (stockPrices[i] > tmpMinPrice) {
                    tmpProfit = stockPrices[i] - tmpMinPrice;
                    if (tmpProfit > maxProfit) {
                        maxProfit = tmpProfit;
                        minPrice = tmpMinPrice;
                        maxPrice = stockPrices[i];
                    }
                } else {
                    if (stockPrices[i] > 0) {
                        tmpMinPrice = stockPrices[i];
                    }
                }
            }
        }
        // if we can't buy and sell then we set the value to zero

        return StockProfit.builder()
                .buyValue(minPrice)
                .sellValue(maxPrice)
                .maxProfit(maxProfit)
                .build();
    }

    public int[] extractStockPrices(RequestDto requestDto) {

        LocalDateTime startTradingTime = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN.plusHours(10));

        log.info("Start Trading Time: {}", startTradingTime);
        log.info("Requested Start Time: {}", requestDto.getStartDateTime());
        log.info("Requested End Time: {}", requestDto.getEndDateTime());

        int[] stockPrices = {};
        if (requestDto.getEndDateTime().isAfter(requestDto.getStartDateTime())
                && requestDto.getStartDateTime().isAfter(startTradingTime)
                && MapUtils.isNotEmpty(requestDto.getStockPrices())) {
            long startMinutes = Duration.between(startTradingTime, requestDto.getStartDateTime()).toMinutes();
            long endMinutes = Duration.between(startTradingTime, requestDto.getEndDateTime()).toMinutes();

            stockPrices = LongStream.range(startMinutes, endMinutes).boxed()
                    .map(min -> requestDto.getStockPrices().get(min.intValue()))
                    .filter(Objects::nonNull)
                    .mapToInt(Integer::intValue).toArray();
        }

        log.info("Stock prices: {}", stockPrices);

        return stockPrices;
    }

}
