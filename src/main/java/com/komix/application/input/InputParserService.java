package com.komix.application.input;

import com.komix.application.input.dto.ParsedInput;

public interface InputParserService {

    ParsedInput parseInput(String line);

}
