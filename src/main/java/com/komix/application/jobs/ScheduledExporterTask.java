package com.komix.application.jobs;

import com.komix.application.export.ExportService;
import com.komix.application.repository.RecordRepository;
import com.komix.application.repository.dto.ExportData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
@Slf4j
public class ScheduledExporterTask {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private ExportService exportService;

    @Scheduled(fixedRateString = "${job.fixedRate}", initialDelayString = "${job.initialDelay}")
    public void scheduleTaskWithFixedRate() {
        log.info("Fixed exporter Task started");

        List<ExportData> data = recordRepository.exportData();
        data.sort(Comparator.comparing(ExportData::getWeight).reversed());
        exportService.exportActualState(data);

        log.info("Fixed exporter Task finished");
    }
}
