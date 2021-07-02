package com.komix.application.input;

import com.komix.application.input.dto.ParsedInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class InputParserServiceTest {


    private InputParserService service;

    @BeforeEach
    void init() {
        service = new InputParserServiceImpl();
    }

    @Test
    void parseInput_allowedFormat_returnParsedObject() {
        ParsedInput result = service.parseInput("140 55501");

        Assertions.assertEquals("55501", result.getPostalCode(), "neocekavany");
        Assertions.assertEquals(BigDecimal.valueOf(140), result.getWeight(), "neocekavany");
    }

    @Test
    void parseInput_allowedFormatWithDecimal_returnParsedObject() {
        ParsedInput result = service.parseInput("140.51 55501");

        Assertions.assertEquals("55501", result.getPostalCode(), "neocekavany");
        Assertions.assertEquals(BigDecimal.valueOf(140.51), result.getWeight(), "neocekavany");
    }


}
