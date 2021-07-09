package com.komix.application.input;

public interface InputValidatorService {

    /**
     * Check line from input
     * @param line - input line
     * @return true - input is valid, false - input is invalid
     */
    boolean isInputValid(String line);

}
