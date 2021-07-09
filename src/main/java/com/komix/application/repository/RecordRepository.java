package com.komix.application.repository;

import com.komix.application.repository.dto.ExportData;

import java.math.BigDecimal;
import java.util.List;

public interface RecordRepository {

    /**
     * Put record into repository
     * @param postalCode - postalCode
     * @param weight - weight
     */
    void putRecord(String postalCode, BigDecimal weight);

    /**
     * Returns actual state for export
     * @return - data for export
     */
    List<ExportData> exportData();
}
