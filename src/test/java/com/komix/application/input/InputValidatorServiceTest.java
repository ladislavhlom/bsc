package com.komix.application.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorServiceTest {


    private InputValidatorServiceImpl inputValidatorService;

    @BeforeEach
    void init() {
        inputValidatorService = new InputValidatorServiceImpl();
    }


    @ParameterizedTest
    @CsvSource({"544 40121", "452.1 54546", "452.21 45654", "452.333 56565"})
    void isInputValid_allowedFormat_returnsTrue(String input) {

        boolean result = inputValidatorService.isInputValid(input);

        Assertions.assertTrue(result, "neocekavany");
    }

    @ParameterizedTest
    @CsvSource({"544 asd", "452.1444 54546", "452.21 456544", "452. 56565", "452.44 5656"})
    void isInputValid_notAllowedFormat_returnsFalse(String input) {

        boolean result = inputValidatorService.isInputValid(input);

        Assertions.assertFalse(result, "neocekavany");
    }
}
