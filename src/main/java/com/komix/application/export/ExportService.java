package com.komix.application.export;

import com.komix.application.repository.dto.ExportData;

import java.util.List;

public interface ExportService {

    /**
     * Export actual state to defined output
     * @param data - actual state
     */
    void exportActualState(List<ExportData> data);
}
