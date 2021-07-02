package com.komix.application.export;

import com.komix.application.repository.dto.ExportData;

import java.util.List;

public interface ExportService {

    void exportActualState(List<ExportData> data);
}
