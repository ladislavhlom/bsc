package com.komix.application.export;

import com.komix.application.repository.dto.ExportData;

public interface OutputService {

    /**
     * Print data to output
     * @param data - output data
     */
    void printExportData(ExportData data);
}
