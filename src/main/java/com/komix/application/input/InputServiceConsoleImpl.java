package com.komix.application.input;

import com.komix.application.service.DataProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Slf4j
public class InputServiceConsoleImpl implements InputService {

    private static final String EXIT_LINE = "quit";

    @Autowired
    private InputValidatorServiceImpl validatorService;

    @Autowired
    private InputParserServiceImpl parserService;

    @Autowired
    private DataProcessService dataProcessService;

    @Override
    public void startReadingInput() {
        Scanner scanner = new Scanner(System.in);

        log.info("Reading input from user");
        while (true) {
            String line = scanner.nextLine();
            if (EXIT_LINE.equals(line)) {
                return;
            }
            if (validatorService.isInputValid(line)) {
                dataProcessService.process(parserService.parseInput(line));
            } else {
                log.error("Wrong input, {} is not in valid format", line);
            }
        }
    }
}
