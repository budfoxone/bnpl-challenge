package com.bnpl.challenge.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestDto {

    private String identifier;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Map<Integer, Integer> stockPrices;

}
