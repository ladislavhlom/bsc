package com.komix.application.export;

import com.komix.application.repository.dto.ExportData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExportServiceImpl implements ExportService {

    @Autowired
    private OutputService outputService;

    @Override
    public void exportActualState(List<ExportData> data) {
        data.forEach(t -> outputService.printExportData(t));
    }
}
