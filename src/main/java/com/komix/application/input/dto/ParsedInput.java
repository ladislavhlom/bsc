package com.komix.application.input.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ParsedInput {

    private String postalCode;
    private BigDecimal weight;
}
