package com.komix.application.input;

import com.komix.application.input.dto.ParsedInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

class InputParserServiceTest {


    private InputParserService service;

    @BeforeEach
    void init() {
        service = new InputParserServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("provideValidDataFormat")
    void parseInput_allowedFormat_returnParsedObject(String inputLine, String expectedPostalCode, BigDecimal expectedWeight) {
        ParsedInput result = service.parseInput(inputLine);

        Assertions.assertEquals(expectedPostalCode, result.getPostalCode(), "Postal code vraci chybnou hodnotu");
        Assertions.assertEquals(expectedWeight, result.getWeight(), "Weight vraci chybnou hodnotu");
    }

    private static Stream<Arguments> provideValidDataFormat() {
        return Stream.of(
                Arguments.of("140.51 55501", "55501", BigDecimal.valueOf(140.51)),
                Arguments.of("140 55501", "55501", BigDecimal.valueOf(140))
        );
    }

}
