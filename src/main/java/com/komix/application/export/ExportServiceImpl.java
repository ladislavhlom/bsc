package com.komix.application.export;

import com.komix.application.repository.dto.ExportData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExportServiceImpl implements ExportService {

    private final OutputService outputService;

    @Override
    public void exportActualState(List<ExportData> data) {
        data.forEach(outputService::printExportData);
    }
}
