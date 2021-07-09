package com.komix.application.input;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class InputValidatorServiceImpl implements InputValidatorService {


    private static final Pattern PATTERN_INPUT = Pattern.compile("^(\\d*\\.?\\d+) (\\d+)$");
    private static final Pattern PATTERN_WEIGHT = Pattern.compile("^(\\d+)(?:.\\d{1,3})?\\r?$");
    private static final Pattern PATTERN_POSTAL_CODE = Pattern.compile("^[0-9]{5}$");

    @Override
    public boolean isInputValid(String line) {

        Matcher matcher = PATTERN_INPUT.matcher(line);

        if (!matcher.matches()) {
            return false;
        }

        String weight = matcher.group(1);
        String postalCode = matcher.group(2);

        Predicate<String> weightValidation = t -> PATTERN_WEIGHT.matcher(t).matches();
        Predicate<String> postalCodeValidation = t -> PATTERN_POSTAL_CODE.matcher(t).matches();

        return weightValidation.test(weight) && postalCodeValidation.test(postalCode);
    }


}
