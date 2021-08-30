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
        int minPriceIndex = 0;
        int maxPriceIndex = 0;

        if (ArrayUtils.isNotEmpty(stockPrices)) {
            // get the lowest price you can get the stock
            minPrice = NumberUtils.min(stockPrices);
            minPriceIndex = ArrayUtils.indexOf(stockPrices, minPrice);
            // after acquiring the lowest price, get the sell price starting off the lowest price index
            int[] stockMaxPrice = ArrayUtils.subarray(stockPrices, minPriceIndex, stockPrices.length);
            if (ArrayUtils.isNotEmpty(stockMaxPrice)) {
                maxPrice = NumberUtils.max(stockMaxPrice);
                maxPriceIndex = ArrayUtils.indexOf(stockPrices, maxPrice);
            }
        }
        int maxProfit = (maxPrice > 0 ? maxPrice : minPrice) - minPrice;
        return StockProfit.builder()
                .buyValue(minPrice)
                .sellValue(maxPrice)
                .maxProfit(maxProfit)
                .buyValueIndex(minPriceIndex)
                .sellValueIndex(maxPriceIndex)
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
