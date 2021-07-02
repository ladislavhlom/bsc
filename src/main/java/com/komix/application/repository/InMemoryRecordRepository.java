package com.komix.application.repository;

import com.komix.application.repository.dto.ExportData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InMemoryRecordRepository implements RecordRepository {

    private final Map<String, BigDecimal> records = new ConcurrentHashMap<>();

    @Override
    public void putRecord(String postalCode, BigDecimal weight) {
        log.info("Puting record into map: {} {}", postalCode, weight);
        if (records.containsKey(postalCode)) {
            records.replace(postalCode, records.get(postalCode).add(weight));
        } else {
            records.put(postalCode, weight);
        }
    }

    @Override
    public List<ExportData> exportData() {
        return records.entrySet().stream()
                .map(t -> ExportData.builder()
                        .postalCode(t.getKey())
                        .weight(t.getValue())
                        .build())
                .collect(Collectors.toList());
    }

}
