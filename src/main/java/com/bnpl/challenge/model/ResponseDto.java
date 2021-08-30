package com.bnpl.challenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    private RequestDto request;
    private LocalDateTime processedDateTime;
    private int maxProfit;
    private int buyValue;
    private int sellValue;

}
