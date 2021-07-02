package com.komix.application.repository.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ExportData {

    private String postalCode;
    private BigDecimal weight;
}
