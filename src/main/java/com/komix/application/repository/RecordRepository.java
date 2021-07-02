package com.komix.application.repository;

import com.komix.application.repository.dto.ExportData;

import java.math.BigDecimal;
import java.util.List;

public interface RecordRepository {

    void putRecord(String postalCode, BigDecimal weight);

    List<ExportData> exportData();
}
