package com.komix.application.export;

import com.komix.application.repository.dto.ExportData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Service
@Slf4j
public class OutputServiceConsoleImpl implements OutputService {

    private final DecimalFormat df = new DecimalFormat();

    @Value("${output.fraction.digits}")
    private int fractionDigits;

    @PostConstruct
    private void postConstruct() {
        df.setMaximumFractionDigits(fractionDigits);
        df.setMinimumFractionDigits(fractionDigits);
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(otherSymbols);
    }

    @Override
    public void printExportData(ExportData data) {
        System.out.println(
                String.format("%s %s", data.getPostalCode(), df.format(data.getWeight()))
        );
    }
}
