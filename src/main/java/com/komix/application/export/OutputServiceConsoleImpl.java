package com.komix.application.export;

import com.komix.application.repository.dto.ExportData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Service
@Slf4j
public class OutputServiceConsoleImpl implements OutputService {

    private final DecimalFormat df = new DecimalFormat();

    @PostConstruct
    private void postConstruct() {
        df.setMaximumFractionDigits(3);
        df.setMinimumFractionDigits(3);
        DecimalFormatSymbols decimalFormatSymbol = new DecimalFormatSymbols(Locale.getDefault());
        decimalFormatSymbol.setDecimalSeparator('.');
        decimalFormatSymbol.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(decimalFormatSymbol);
    }

    @Override
    public void printExportData(ExportData data) {
        System.out.println(
                String.format("%s %s", data.getPostalCode(), df.format(data.getWeight()))
        );
    }
}
