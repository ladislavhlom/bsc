package com.komix.application.input;

import com.komix.application.input.dto.ParsedInput;

public interface InputParserService {

    /**
     * Parse input and return defined response
     * @param line - valid input line
     * @return - response with parsed values
     */
    ParsedInput parseInput(String line);

}
