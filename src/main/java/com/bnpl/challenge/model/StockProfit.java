package com.bnpl.challenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockProfit {

    private int buyValue;
    private int buyValueIndex;
    private int sellValue;
    private int sellValueIndex;
    private int maxProfit;
}
